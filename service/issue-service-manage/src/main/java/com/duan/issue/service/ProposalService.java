package com.duan.issue.service;

import com.duan.issue.common.dto.ProposalDTO;
import com.duan.issue.common.enums.SubjectType;
import com.duan.issue.common.exceptions.ProposalException;

/**
 * Created on 2019/10/28.
 *
 * @author DuanJiaNing
 */
public interface ProposalService {

    ProposalDTO proposalDeleteSubject(int subjectId, SubjectType type, String reason) throws ProposalException;

    ProposalDTO agree(int id);

    ProposalDTO disagree(int id);
}
