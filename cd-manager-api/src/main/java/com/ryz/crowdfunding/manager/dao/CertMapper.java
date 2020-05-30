package com.ryz.crowdfunding.manager.dao;

import com.ryz.crowdfunding.bean.Cert;
import com.ryz.crowdfunding.bean.MemberCert;

import java.util.List;

public interface CertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cert record);

    Cert selectByPrimaryKey(Integer id);

    List<Cert> selectAll();

    int updateByPrimaryKey(Cert record);

    List<Cert> queryCertByAccttype(String accttype);

    void insertMemberCert(MemberCert memberCert);
}