package com.duan.issue.impl;

import com.duan.issue.base.exceptions.InternalException;
import com.duan.issue.base.util.DataConverter;
import com.duan.issue.common.ProposalSubjectFactory;
import com.duan.issue.common.dto.ProposalDTO;
import com.duan.issue.common.entity.Proposal;
import com.duan.issue.common.enums.ProposalStatus;
import com.duan.issue.common.enums.ProposalSubjectType;
import com.duan.issue.common.enums.ProposalType;
import com.duan.issue.common.exceptions.ProposalException;
import com.duan.issue.dao.ProposalDao;
import com.duan.issue.service.ProposalService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2019/10/29.
 *
 * @author DuanJiaNing
 */
@Service
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    private ProposalDao proposalDao;

    @Autowired
    private ProposalSubjectFactory proposalSubjectFactory;

    private Proposal getById(int id) throws ProposalException {
        Proposal proposal = proposalDao.findById(id);
        if (proposal == null) {
            throw new ProposalException("Proposal is not exist with id=" + id);
        }

        return proposal;
    }

    private void update(Proposal ct) throws ProposalException {
        if (proposalDao.update(ct) != 1) {
            throw new ProposalException("Fail to update proposal", new InternalException("DB"));
        }
    }

    @Override
    public ProposalDTO proposalDeleteSubject(int subjectId, ProposalSubjectType subjectType, String reason)
            throws ProposalException {
        if (StringUtils.isBlank(reason)) {
            throw new ProposalException("proposal reason can not be empty");
        }

        if (subjectType == null) {
            throw new ProposalException("proposal subject type can not be null");
        }

        com.duan.issue.base.service.Service subjectService = proposalSubjectFactory.getSubjectService(subjectType);
        if (subjectService == null) {
            throw new ProposalException("proposal subject type not support");
        }

        Object dto = subjectService.get(subjectId);
        if (dto == null) {
            throw new ProposalException("proposal subject with id=" + subjectId + "not exist");
        }

        Proposal ps = new Proposal();
        ps.setStatus(ProposalStatus.OPEN.ordinal());
        ps.setReason(reason);
        ps.setProposalType(ProposalType.DELETE.ordinal());
        ps.setSubjectType(subjectType.ordinal());
        ps.setSubjectId(subjectId);
        if (proposalDao.insert(ps) != 1) {
            throw new ProposalException("Fail to add proposal", new InternalException("DB"));
        }

        Proposal aps = getById(ps.getId());
        return DataConverter.map(aps, ProposalDTO.class);
    }

    @Override
    public ProposalDTO agree(int id) throws ProposalException {
        Proposal proposal = getById(id);
        if (ProposalStatus.CLOSE.ordinal() == proposal.getStatus()) {
            throw new ProposalException("Proposal status illegal: CLOSE, conflict with current operational.");
        }

        Proposal ps = new Proposal();
        ps.setId(proposal.getId());
        int newAgree = proposal.getAgree() + 1;
        ps.setAgree(newAgree);
        update(ps);

        return DataConverter.map(getById(id), ProposalDTO.class);
    }

    @Override
    public ProposalDTO disagree(int id) throws ProposalException {
        Proposal proposal = getById(id);
        if (ProposalStatus.CLOSE.ordinal() == proposal.getStatus()) {
            throw new ProposalException("Proposal status illegal: CLOSE, conflict with current operational.");
        }

        Proposal ps = new Proposal();
        ps.setId(proposal.getId());
        int newDisagree = proposal.getDisagree() + 1;
        ps.setDisagree(newDisagree);
        update(ps);

        return DataConverter.map(getById(id), ProposalDTO.class);
    }
}
