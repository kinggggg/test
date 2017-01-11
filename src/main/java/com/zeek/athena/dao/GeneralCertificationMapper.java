package com.zeek.athena.dao;

import com.zeek.athena.domain.GeneralCertification;

public interface GeneralCertificationMapper {
    int deleteByPrimaryKey(String id);

    int insert(GeneralCertification record);

    int insertSelective(GeneralCertification record);

    GeneralCertification selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GeneralCertification record);

    int updateByPrimaryKey(GeneralCertification record);
}