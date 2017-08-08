package com.template.helpers;

import org.apache.commons.lang.RandomStringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


public class Utils {
    private static Random randomGenerator = new Random();

    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void wait(double seconds) {
        try {
            Thread.sleep((long) (1000 * seconds));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getPathInsideProject(String path) {
        File directory = new File("./" + path);
        try {
            return directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void createFolder(String path) {
        File theDir = new File("./" + path);
        theDir.mkdirs();
    }


    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static String getShortCurrentDate() {
        DateFormat df = new SimpleDateFormat("ddHHmm");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }

    public static String getCurrentTime() {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }

    public static void writeToFile(String file_path, String message) {
        try {
            FileWriter fstream = new FileWriter(file_path, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(message);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJoinedStringArrayValues(ArrayList<String> values) {
        String result = "";
        for (String product : values) {
            result += product + ", ";
        }
        return result.substring(0, result.length() - 2);
    }

    public static <T> T randomItemFromCollection(Collection<T> list) {
        int randomIndex = randomGenerator.nextInt(list.size());
        return list.stream().collect(Collectors.toList()).get(randomIndex);
    }

    public static int randomNumberFromAndTo(int min, int max) {
        return randomGenerator.nextInt(max - min + 1) + min;
    }

    public static String getTextFromClipboard() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String result = "";
        try {
            result = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String formatToHexFromRgb(String[] rgb) {
        try {
            return String.format("#%s%s%s", toBrowserHexValue(Integer.parseInt(rgb[0])), toBrowserHexValue(Integer.parseInt(rgb[1])), toBrowserHexValue(Integer.parseInt(rgb[2])));
        } catch (NumberFormatException ex) {
            return Arrays.toString(rgb).replace("[", "").replace("]", "");
        }
    }

    private static String toBrowserHexValue(int number) {
        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.append("0");
        }
        return builder.toString().toUpperCase();
    }

    public static String randomText() {
        return RandomStringUtils.randomAlphabetic(13);
    }

    public static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
        public int compare(String str1, String str2) {
            int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
            return (res != 0) ? res : str1.compareTo(str2);
        }
    };

    public static <T> void removeDuplicates(ArrayList<T> list) {
        int size = list.size();
        int out = 0;
        {
            final Set<T> encountered = new HashSet<>();
            for (int in = 0; in < size; in++) {
                final T t = list.get(in);
                final boolean first = encountered.add(t);
                if (first)
                    list.set(out++, t);
            }
        }
        while (out < size) {
            list.remove(--size);
        }
    }

    public static String hashValue(String message, String secret, String hashAlgorithm) {
        try {
            Mac macCode = Mac.getInstance(hashAlgorithm);
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), hashAlgorithm);
            macCode.init(secret_key);
            return byteArrayToHex(macCode.doFinal(message.getBytes()));
        } catch (Exception e) {
            return "Exception";
        }
    }

    public static String MD5(String str) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(str.getBytes());
            return byteArrayToHex(array);
        } catch (java.security.NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String sha1(String str) throws UnsupportedEncodingException {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-1");
            byte[] array = md.digest(str.getBytes());
            return byteArrayToHex(array);
        } catch (java.security.NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String sha256(String str) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] array = md.digest(str.getBytes());
            return byteArrayToHex(array);
        } catch (java.security.NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String base64sha256(String data, String key) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret = new SecretKeySpec(key.getBytes(), "HmacSHA256");

            mac.init(secret);
            byte[] digest = mac.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(digest);
        } catch (Exception e) {
            return null;
        }
    }

    public static String base64Format(String hash) {
        try {
            return Base64.getUrlEncoder().encodeToString(hash.getBytes("ASCII"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "Exception";
        }
    }

    public static String byteArrayToHex(byte[] barray) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < barray.length; i++) {
            String hex = Integer.toHexString(0xff & barray[i]);
            if (hex.length() == 1) sb.append('0');
            sb.append(hex);
        }
        return sb.toString();
    }

    public static String uniteStringOfValuesFromMap(Map<String, String> map) {
        StringBuilder params = new StringBuilder();
        for (HashMap.Entry data : map.entrySet()) {
            params.append(data.getValue());
        }
        return params.toString();
    }

    public static String turnNumberInKbillFormat(String number) {
        return String.valueOf(number).replaceFirst("(\\d)(\\d{3})(\\d{3})(\\d+)", "$1($2) $3-$4");
    }

    public static LocalDate randomLocalDate() {
        return LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(LocalDate.now().toEpochDay(), LocalDate.now().plusYears(2).toEpochDay()));
    }

    public static LocalDateTime formatDateToLocalDateTime(Object date) {
        String cleverFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSz";
        String cleverFormatWithoutZ = "yyyy-MM-dd'T'HH:mm:ss.SSS";
        String format = "yyyy-MM-dd HH:mm:ss";
//        String newFormat = "yyyy-MM-dd'T'HH:mm:ssZ";
        String subsFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSz";
        String subs5Format = "yyyy-MM-dd'T'HH:mm:ss.SSSSSz";
        String nullFormat = "0000-00-00";

        String regExpWithoutSeconds = "\\d{4}-\\d{2}-\\d{2}";
        String regExpWithSeconds = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}Z";
        String regExpWithOutZ = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}";
        String regExpforSubs = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{6}Z";
        String regExp5forSubs = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{5}Z";
        String newRegExpforSubs = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z";

        if (date.toString().matches(nullFormat)) {
            return LocalDateTime.now();
        } else if (date.toString().matches(regExpWithSeconds)) {
            return LocalDateTime.parse(date.toString(), DateTimeFormatter.ofPattern(cleverFormat));
        } else if (date.toString().matches(regExpWithoutSeconds)) {
            return LocalDateTime.parse(date.toString().concat(" 00:00:00"), DateTimeFormatter.ofPattern(format));
        } else if (date.toString().matches(regExpWithOutZ)) {
            return LocalDateTime.parse(date.toString(), DateTimeFormatter.ofPattern(cleverFormatWithoutZ));
        } else if (date.toString().matches(regExpforSubs)) {
            return LocalDateTime.parse(date.toString(), DateTimeFormatter.ofPattern(subsFormat));
        } else if (date.toString().matches(regExp5forSubs)) {
            return LocalDateTime.parse(date.toString(), DateTimeFormatter.ofPattern(subs5Format));
        } else if (date.toString().matches(newRegExpforSubs)) {
            return LocalDateTime.parse(date.toString(), DateTimeFormatter.ISO_ZONED_DATE_TIME.withZone(ZoneId.systemDefault()));
        } else {
            return LocalDateTime.parse(date.toString(), DateTimeFormatter.ofPattern(format));
        }
    }

    public static double round(double number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        double tmp = number * pow;
        return (double) (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) / pow;
    }
}
