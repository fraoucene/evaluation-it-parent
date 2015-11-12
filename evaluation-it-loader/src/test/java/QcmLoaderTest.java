import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by fraoucene on 09/11/2015.

public class QcmLoaderTest {


    public static final Logger LOGGER = LoggerFactory.getLogger(QcmLoaderTest.class);
    @Autowired
    CategoriesService categoriesService;

    @Test
    public void get_all_test() throws Exception {
        String qcmJsonPath = "C:\\Users\\fraoucene\\Desktop\\workspace\\config\\data\\newQcm.json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Map<String,Object>>> qcmJsonData = mapper.readValue(new File(qcmJsonPath), Map.class);
        List<Map<String, Object>> qcmList = qcmJsonData.get("data");

        Categories category= new Categories("aaaa");
        categoriesService.createCategory(category);
        for (Map<String, Object> qcm : qcmList) {

            LOGGER.warn("-- qcm= {}", qcm);
        }


    }

}
 */