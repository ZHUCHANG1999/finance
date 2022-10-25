package com.atguigu.srb.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.srb.core.mapper.DictMapper;
import com.atguigu.srb.core.pojo.dto.ExcelDictDTO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@NoArgsConstructor
public class ExcelDictDTOListener extends AnalysisEventListener<ExcelDictDTO> {
    //数据列表
    private static final int BATCH_COUNT = 5;
    private List<ExcelDictDTO> list = new ArrayList<>();

    private DictMapper dictMapper;
    //传入mapper对象

    public ExcelDictDTOListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }


    //每5条记录批量存储一次数据

    @Override
    public void invoke(ExcelDictDTO data, AnalysisContext context) {
        log.info("解析到一条记录: {}", data);
        list.add(data);
        if(list.size() >= BATCH_COUNT){
            //调用mapper的save方法
            saveData();
            list.clear();
        }

    }


    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData(){
        log.info("{}条数据，开始存储数据库！",list.size());
        dictMapper.insertBatch(list);
        log.info("存储数据库成功");

    }
}
