package com.template.helpers;

public class Logging {
    public final static String FOLDER_WITH_LOGS = "LOGS/";
    private final static String LINE_SEPARATOR = System.getProperty("line.separator");
    private static Logging requestsLog;
    private static Logging log;
    private static Logging failsLog;
    private String path;
    private static String messages;
    private static String assertFailMessage;

    static {
        log = new Logging(generateNewLogFilePath());
    }

    static {
        requestsLog = new Logging(generateNewRequestsLogFilePath());
    }

    static {
        failsLog = new Logging(generateNewFailsFilePath());
    }

    public Logging(String log_path) {
        this.path = log_path;
    }

    public static Logging getLogging() {
        return log;
    }

    public static Logging getRequestsLogging() {
        return requestsLog;
    }

    public static Logging getFailsLogging() {
        return failsLog;
    }

    public static String generateNewLogFilePath() {
        String log_file_name = "log-" + Utils.getCurrentDate() + ".txt";
        return Utils.getPathInsideProject(FOLDER_WITH_LOGS + log_file_name);
    }

    public static String generateNewRequestsLogFilePath() {
        String log_file_name = "requests-log.txt";
        return Utils.getPathInsideProject(FOLDER_WITH_LOGS + log_file_name);
    }

    public static String generateNewFailsFilePath() {
        String log_file_name = "fails-log.txt";
        return Utils.getPathInsideProject(FOLDER_WITH_LOGS + log_file_name);
    }

    public void writeLog(String logPath, String message, int emptyLinesNumber) {
        String date = Utils.getCurrentTime();
        if(logPath.contains("fails-log.txt")) {
            date = "";
        }
        String formatted_message = "";
        if (emptyLinesNumber >= 1) {
            for (int i = 1; i <= emptyLinesNumber; i++) {
                formatted_message += LINE_SEPARATOR;
            }
        }
        formatted_message += date + " " + message;
        Utils.writeToFile(logPath, formatted_message);
        if(!logPath.contains("fails-log.txt")) {
            Utils.writeToFile(FOLDER_WITH_LOGS + "general-log.txt", formatted_message);
            messages += formatted_message;
        }
    }

    public void clearMessagesBuffer(){
        messages = "";
    }

    public String getMessages(){
        return messages;
    }

    public String writeAssertLog(String message){
        assertFailMessage = message;
        return message;
    }

    public String getAssertFailMessage() {
        return assertFailMessage;
    }

    public void writeLog(String message) {
        writeLog(path, message, 1);
    }

    public void writeLog(String message, int emptyLinesNumber) {
        writeLog(path, message, emptyLinesNumber);
    }
}