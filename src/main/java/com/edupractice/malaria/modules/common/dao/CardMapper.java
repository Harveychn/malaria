package com.edupractice.malaria.modules.common.dao;

import com.edupractice.malaria.modules.common.pojo.Card;
import com.edupractice.malaria.modules.common.pojo.CardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardMapper {
    int countByExample(CardExample example);

    int deleteByExample(CardExample example);

    int deleteByPrimaryKey(Integer cardId);

    int insert(Card record);

    int insertSelective(Card record);

    List<Card> selectByExample(CardExample example);

    Card selectByPrimaryKey(Integer cardId);

    int updateByExampleSelective(@Param("record") Card record, @Param("example") CardExample example);

    int updateByExample(@Param("record") Card record, @Param("example") CardExample example);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);
}