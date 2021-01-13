package Helper.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.read.listener.ReadListener;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestEasyExcel {
    @Test
    public void TestWrite(){
        String fileName="C:\\Users\\hukaiwen\\Desktop\\write.xlsx";
        List<DemoData> lst = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData demoData = new DemoData();
            demoData.setSno(i);
            demoData.setSname("jack"+1);
            lst.add(demoData);
        }
        EasyExcel.write(fileName,DemoData.class).sheet("学生列表").doWrite(lst);
    }

    @Test
    public void TestRead(){
        String fileName="C:\\Users\\hukaiwen\\Desktop\\write.xlsx";
        EasyExcel.read(fileName,DemoData.class,new ExcelListener()).sheet("学生列表").doRead();
    }

    public class ExcelListener extends AnalysisEventListener<DemoData> {

        @Override
        public void invokeHead(Map<Integer, CellData> map, AnalysisContext analysisContext) {
            System.out.println(map);
        }

        @Override
        public void invoke(DemoData demoData, AnalysisContext analysisContext) {
            System.out.println(demoData);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        }
    }
}
