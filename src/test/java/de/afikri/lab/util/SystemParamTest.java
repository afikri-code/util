package de.afikri.lab.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SystemParamTest {
    SystemParam sysParam;
    @BeforeEach
    void setUp(){
        sysParam = new SystemParam();
    }
    @Test
    void findKeyThatExists(){
        assertThat(sysParam.findKey("tmp"),equalTo("java.io.tmpdir"));
    }

    @Test
    void findKeyThatDoesntExist(){
        assertThat(sysParam.findKey("abc"),equalTo(" "));
    }

    @Test
    void findKeyEmptyArg(){
        assertThat(sysParam.findKey(""),equalTo("-"));
        assertThat(sysParam.findKey("  "),equalTo("-"));
        assertThat(sysParam.findKey(null),equalTo("-"));
    }

    @Test
    void getParam(){
        assertThat(sysParam.getParam("tmp"),not(emptyOrNullString()));
    }

    @Test
    void getParamNotFound(){
        assertThat(sysParam.getParam("abc"),is(emptyOrNullString()));
    }
}