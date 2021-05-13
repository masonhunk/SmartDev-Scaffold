package com.webank.scaffold.artifact.dir;

import com.webank.scaffold.artifact.file.DemoPkeyTestJava;
import com.webank.scaffold.config.UserConfig;
import com.webank.scaffold.util.IOUtil;

import java.io.File;

/**
 * @author aaronchu
 * @Description
 * @data 2021/01/20
 */
public class TestJavaDir extends DirectoryArtifact {

    private UserConfig config;

    public TestJavaDir(File parentDir,  UserConfig userConfig) {
        super(parentDir);
        this.config = userConfig;
    }

    @Override
    protected void doGenerateSubContents() throws Exception {
        /**
         * 1. Build sub directory due to package name
         */
        handleDemoPkey();
    }

    @Override
    public String getName() {
        return "java";
    }

    private void handleDemoPkey()  throws Exception{
        File javaDir = this.toFile();
        String utilsPackage = config.getGroup() + "." + config.getArtifact();
        DemoPkeyTestJava demoPkeyTestJava = new DemoPkeyTestJava(IOUtil.convertPackageToFile(javaDir,utilsPackage), config);
        demoPkeyTestJava.generate();
    }
}
