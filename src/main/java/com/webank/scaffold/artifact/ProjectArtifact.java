package com.webank.scaffold.artifact;

import com.webank.scaffold.config.GeneratorOptions;
import com.webank.scaffold.config.UserConfig;
import com.webank.scaffold.util.IOUtil;

import java.io.File;

/**
 * @author aaronchu
 * @Description
 * @data 2021/01/19
 */
public class ProjectArtifact extends DirectoryArtifact {

    private String projectName;

    public ProjectArtifact(File basePath, UserConfig config) {
        super(basePath);
        this.projectName = config.getProperty(GeneratorOptions.GENERATOR_ARTIFACT);
    }

    @Override
    public String getName() {
        return this.projectName;
    }

    @Override
    protected void doGenerateSubContents() throws Exception {

    }

    public void clean(){
        IOUtil.removeItem(this.toFile());
    }
}
