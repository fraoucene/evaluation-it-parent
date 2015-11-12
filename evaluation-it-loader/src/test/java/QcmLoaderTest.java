import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fraoucene.evaluation.it.api.model.Choices;
import com.fraoucene.evaluation.it.api.model.QuestionMultiChoices;
import com.fraoucene.evaluation.it.api.model.Questions;
import com.fraoucene.evaluation.it.api.services.CategoriesService;
import com.fraoucene.loader.helpers.LoaderHelper;
import com.fraoucene.loader.model.Qcm;
import com.fraoucene.loader.model.QcmData;
import com.fraoucene.loader.model.QuestionsJson;
import org.junit.Test;
import com.fraoucene.evaluation.it.api.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by fraoucene on 09/11/2015.
 *
 */
public class QcmLoaderTest {


    @Autowired
    CategoriesService categoriesService;

    @Value("${qcm.json.path}")
    private String qcmJsonPath;

    @Test
    public void get_all_test() throws Exception {
        String qcmJsonPath = "C:\\Users\\fraoucene\\Desktop\\workspace\\config\\data\\newQcm.json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Map<String,Object>>> qcmJsonData = mapper.readValue(new File(qcmJsonPath), Map.class);
        List<Map<String, Object>> qcmList = qcmJsonData.get("data");

    }

    @Test
    public void getTestsData() {
        String qcmJsonPath = "C:\\Users\\fraoucene\\Desktop\\workspace\\config\\data\\newQcm.json";
        QcmData qcmData = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            qcmData = mapper.readValue(new File(qcmJsonPath), new TypeReference<QcmData>() {
            });
            Set<Qcm> qcmList = qcmData.getQcmList();
            for (Qcm qcm : qcmList) {
                LoaderHelper.saveQcm(qcm);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
