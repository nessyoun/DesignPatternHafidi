package com.acco.importerData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Json implements IFileDataImporter{

    @Override
    public List<HashMap<String, Object>> read() throws IOException {
        String filePath = "file.json";
        List<HashMap<String, Object>> dataList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        JsonNode rootNode = objectMapper.readTree(file);
        if (rootNode.isArray()) {
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode element = elements.next();
                HashMap<String, Object> data = parseJsonNode(element);
                dataList.add(data);
            }
        } else {
            HashMap<String, Object> data = parseJsonNode(rootNode);
            dataList.add(data);
        }
        return dataList;
    }
    private static HashMap<String, Object> parseJsonNode(JsonNode jsonNode) {
        HashMap<String, Object> data = new HashMap<>();
        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields.next();
            String key = entry.getKey();
            JsonNode valueNode = entry.getValue();
            Object value = convertJsonNodeToObject(valueNode);
            data.put(key, value);
        }
        return data;
    }

    private static Object convertJsonNodeToObject(JsonNode jsonNode) {
        if (jsonNode.isTextual()) {
            return jsonNode.asText();
        } else if (jsonNode.isInt()) {
            return jsonNode.asInt();
        } else if (jsonNode.isDouble()) {
            return jsonNode.asDouble();
        } else if (jsonNode.isBoolean()) {
            return jsonNode.asBoolean();
        } else {
            return null;
        }
    }

    @Override
    public IDataImporter build() {
        return null;
    }

    @Override
    public IFileDataImporter addPath() {
        return null;
    }
}
