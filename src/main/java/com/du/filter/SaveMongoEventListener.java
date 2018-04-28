package com.du.filter;

import com.du.annotation.MongoGeneratedValue;
import com.du.document.SequenceId;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;

/**
 * @author duqifeng
 * 2018/4/28 18:24
 */
@Component
public class SaveMongoEventListener extends AbstractMongoEventListener<Object> {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        if (event.getSource() != null) {
            ReflectionUtils.doWithFields(event.getSource().getClass(), new ReflectionUtils.FieldCallback() {
                public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                    ReflectionUtils.makeAccessible(field);
                    if (field.isAnnotationPresent(MongoGeneratedValue.class)) {
                        //设置自增ID
                        field.set(event.getSource(), getNextId(event.getSource().getClass().getSimpleName()));
                    }
                }
            });
        }
    }

    /**
     * 获取下一个自增ID
     *
     * @param collName 集合名
     * @return
     * @author yinjihuan
     */
    private Long getNextId(String collName) {
        Query query = new Query(Criteria.where("collName").is(collName));
        Update update = new Update();
        update.inc("seqId", 1);
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.upsert(true);
        options.returnNew(true);
        SequenceId seqId = mongoTemplate.findAndModify(query, update, options, SequenceId.class);
        return seqId.getSeqId();
    }
}
