package com.duan.issue.service;

import com.duan.issue.common.dto.ProposalDTO;
import com.duan.issue.common.enums.ModelType;
import com.duan.issue.common.enums.ProposalType;
import com.duan.issue.common.exceptions.ProposalException;

/**
 * Created on 2019/10/28.
 *
 * @author DuanJiaNing
 */
public interface ProposalService {

    ProposalDTO proposal(ModelType model, ProposalType proposal) throws ProposalException;

    ProposalDTO agree(int id);

    ProposalDTO disagree(int id);
}
