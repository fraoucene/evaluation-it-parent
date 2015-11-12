import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fraoucene.metier.model.QuestionMultiChoices;
import com.fraoucene.metier.services.QuestionMultiChoicesService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by fraoucene on 09/11/2015.
 */


public class LoaderTest {


    @Value("${qcm.json.path}")
    private String qcmJsonPath;

    @Test
    public void get_all_tests() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Map<String,Object>>> qcmJsonData = mapper.readValue(new File("C:/Users/fraoucene/Desktop/workspace/config/data/newQcm.json"), Map.class);
        List<Map<String,Object>> qcmList = qcmJsonData.get("data");
        for (Map<String,Object> qcm : qcmList){

            
        }

    }


}
