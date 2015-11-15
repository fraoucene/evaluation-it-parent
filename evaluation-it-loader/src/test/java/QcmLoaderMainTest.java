import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fraoucene.evaluation.it.dao.services.impl.CategoriesServiceImpl;
import com.fraoucene.loader.model.Qcm;
import com.fraoucene.loader.model.QcmData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Created by fraoucene on 09/11/2015.
 *
 */
public class QcmLoaderMainTest {


    CategoriesServiceImpl categoriesService;

    @Value("${qcm.json.path}")
    private String qcmJsonPath;


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
                //LoaderHelper.saveQcm(qcm);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
