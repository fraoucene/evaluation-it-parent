

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by fraoucene on 09/11/2015.
 */
public class QcmLoader {


    public static void main(String[] args) throws Exception {
        String qcmJsonPath = "C:\\Users\\fraoucene\\Desktop\\workspace\\config\\data\\newQcm.json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Map<String,Object>>> qcmJsonData = mapper.readValue(new File(qcmJsonPath), Map.class);

    }


}
