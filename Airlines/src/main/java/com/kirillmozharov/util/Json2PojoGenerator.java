package com.kirillmozharov.util;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Kotov Kirill
 * Copy this class to your project
 * Add dependencies from following link for working with class
 * IMPORTANT!!!!! <version>1.1.1</version>
 * https://mvnrepository.com/artifact/org.jsonschema2pojo/jsonschema2pojo-core
 */
public class Json2PojoGenerator {

    private final URL source;
    private final File destDir;
    private GenerationConfig config;

    /**
     * Constructor for initialize configuration of generation
     * @param srcFileName - Source file with JSON Object
     * @param resultDirectoryName - Path to your java code folder
     * @throws IOException - Configuration Exception
     */
    public Json2PojoGenerator(String srcFileName, String resultDirectoryName) throws IOException {
        File file = new File(srcFileName);
        destDir = new File(resultDirectoryName);
        source = file.toURI().toURL();
        config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return false;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }

            @Override
            public boolean isIncludeAdditionalProperties() {
                return false;
            }

            @Override
            public boolean isIncludeGeneratedAnnotation() {
                return false;
            }

            @Override
            public boolean isIncludeToString() {
                return false;
            }

            @Override
            public boolean isIncludeHashcodeAndEquals() {
                return false;
            }

            @Override
            public boolean isUsePrimitives() {
                return true;
            }

            @Override
            public boolean isIncludeConstructors() {
                return true;
            }

            @Override
            public boolean isInitializeCollections() {
                return true;
            }
        };
    }

    /**
     * Generate All Schema Classes
     * @param rootClassName - Name Class of Object Root  
     * @param packageName - Name Package of Your Schema
     * @throws IOException - Generation Exception
     */
    public void generate(String rootClassName, String packageName) throws IOException {
        JCodeModel codeModel = new JCodeModel();
        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config,
                new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(codeModel, rootClassName, packageName, source);
        codeModel.build(destDir);
    }
}
