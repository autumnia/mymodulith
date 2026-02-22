package com.autumnia.mymodulith.documentation;

import com.autumnia.mymodulith.MymodulithApplication;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

//@ApplicationModuleTest
public class DocumentaionTests {
    ApplicationModules applicationModules = ApplicationModules.of(MymodulithApplication.class);

    @Test
    void write_documentation_snippets(){
        new Documenter(applicationModules)
                .writeModulesAsPlantUml(
                        Documenter.DiagramOptions.defaults().withStyle(Documenter.DiagramOptions.DiagramStyle.C4)
                )
                .writeIndividualModulesAsPlantUml(
                        Documenter.DiagramOptions.defaults().withStyle(Documenter.DiagramOptions.DiagramStyle.C4)
                )
                .writeModuleCanvases();

        Documenter.DiagramOptions
                .defaults()
                .withStyle(Documenter.DiagramOptions.DiagramStyle.C4);

    }
}

