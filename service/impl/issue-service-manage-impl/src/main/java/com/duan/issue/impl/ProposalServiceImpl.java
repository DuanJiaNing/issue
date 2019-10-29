package com.duan.issue.impl;

import com.duan.issue.common.dto.ProposalDTO;
import com.duan.issue.common.enums.SubjectType;
import com.duan.issue.common.exceptions.ProposalException;
import com.duan.issue.service.ProposalService;
import org.apache.dubbo.config.annotation.Service;

/**
 * Created on 2019/10/29.
 *
 * @author DuanJiaNing
 */
@Service
public class ProposalServiceImpl implements ProposalService {

    @Override
    public ProposalDTO proposalDeleteSubject(int id, SubjectType type, String reason) throws ProposalException {
        return null;
    }

    @Override
    public ProposalDTO agree(int id) {
        return null;
    }

    @Override
    public ProposalDTO disagree(int id) {
        return null;
    }
}
