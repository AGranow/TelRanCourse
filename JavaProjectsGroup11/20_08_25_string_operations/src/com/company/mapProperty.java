package com.company;

import com.company.consumer.IStringOperation;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class mapProperty {

    private Properties props;  // properties - свойства
    private Map<String, IStringOperation> map = new HashMap<>();


    public Map<String, IStringOperation> creatureMap() throws IOException {
        props.load(new FileReader("config.config.props"));
        String operationPackage = props.getProperty("operations_package");
        String operationNames = props.getProperty("operations");
map.put(operationNames.split(","), Class.forName().getConstructor().newInstance());
        return null;
    }




    public mapProperty() throws IOException {
        props = new Properties();
        props.load(new FileReader("config/config.props"));
    }
}
