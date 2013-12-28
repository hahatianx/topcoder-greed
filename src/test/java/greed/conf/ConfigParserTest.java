package greed.conf;

import greed.conf.schema.GreedConfig;

import greed.util.StringUtil;
import org.junit.Test;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigParserTest {
    @Test
    public void testSerialize() throws ConfigException {
        ConfigParser configParser = new ConfigParser();
        Config config = ConfigFactory.parseURL(ConfigParserTest.class.getResource("/default.conf")).resolve();
        System.out.println(config.toString());
        GreedConfig greedConfig = configParser.parseAndCheck("greed", config.getConfig("greed"), GreedConfig.class);
        System.out.println(StringUtil.join(greedConfig.getLanguage().get("java").getTemplateDef().get("source").getTransformers(), ", "));
        System.out.println(greedConfig.getLanguage().get("java").getTemplateDef().get("source").getDependencies());
        System.out.println(greedConfig.getLanguage().get("java").getTemplateDef().get("testcase").getOverwrite());
        System.out.println("done");
    }
}
