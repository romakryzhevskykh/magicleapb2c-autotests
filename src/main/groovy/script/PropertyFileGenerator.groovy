package script

import org.yaml.snakeyaml.Yaml

def config_var = System.getProperty(PropertyGenerator.CONFIG_PROPERTY, PropertyGenerator.DEFAULT_CONFIG)
def loader = new PropertyGenerator(config: config_var)
loader.process()

class PropertyGenerator {
    final String YAML_FILE = './src/main/resources/properties.yaml'
    final String PROPERTIES_FILE = './src/main/resources/application.properties'
    final static String CONFIG_PROPERTY = "test.config"
    final static String DEFAULT_CONFIG = "default-config"

    private Yaml propertiesYaml = new Yaml()
    String config
    Properties configProps

    void process() {
        loadProps()
        generatePropFile()
    }

    void loadProps() {
        InputStream streamYamlProperties = new FileInputStream(new File(YAML_FILE))
        def props = propertiesYaml.load(streamYamlProperties)
        configProps = props['properties'][config]
    }

    void generatePropFile() {
        def propsfile = new File(PROPERTIES_FILE)
        propsfile.delete()
        configProps.each { k, v -> propsfile << "${k}=${v}\n" }
    }
}