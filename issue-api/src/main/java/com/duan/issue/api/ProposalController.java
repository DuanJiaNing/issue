package com.duan.issue.api;

import com.duan.issue.common.ResultModel;
import com.duan.issue.common.dto.ProposalDTO;
import com.duan.issue.common.enums.ProposalResponseType;
import com.duan.issue.common.enums.ProposalSubjectType;
import com.duan.issue.common.exceptions.ProposalException;
import com.duan.issue.config.Config;
import com.duan.issue.service.ProposalService;
import com.duan.issue.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2019/10/29.
 *
 * @author DuanJiaNing
 */
@Slf4j
@RestController
@RequestMapping("/proposal")
public class ProposalController {

    @Reference
    private ProposalService proposalService;

    @Autowired
    private Config config;

    @PostMapping(":DELETE/{subjectType: TOPIC | COMMENT}")
    public ResultModel<ProposalDTO> proposalDeleteComment(@PathVariable String subjectType,
                                                          @RequestBody ProposalDTO proposal) {
        ProposalSubjectType st = ProposalSubjectType.valueOf(subjectType);
        if (StringUtils.isBlank(proposal.getReason())) {
            return ResultUtils.error("请输入原因");
        }

        Config.Manage manage = config.manage();
        if (proposal.getReason().length() > manage.getProposalWordLimit()) {
            return ResultUtils.error("字数需要控制在 " + manage.getProposalWordLimit() + " 字以内");
        }

        if (proposal.getSubjectId() == null) {
            return ResultUtils.fail("missing parameter: subjectId", HttpStatus.BAD_REQUEST);
        }

        try {
            ProposalDTO dto = proposalService.proposalDeleteSubject(proposal.getSubjectId(), st, proposal.getReason());
            return ResultUtils.success(dto);
        } catch (ProposalException e) {
            return ResultUtils.fail(e);
        }
    }

    @PutMapping(":{response: AGREE | DISAGREE}/{proposalId}")
    public ResultModel<ProposalDTO> agreeProposal(@PathVariable Integer proposalId, @PathVariable String response) {
        ProposalResponseType pt = ProposalResponseType.valueOf(response);
        try {
            switch (pt) {
                case AGREE:
                    return ResultUtils.success(proposalService.agree(proposalId));
                case DISAGREE:
                    return ResultUtils.success(proposalService.disagree(proposalId));
            }
        } catch (ProposalException e) {
            return ResultUtils.fail(e);
        }

        return ResultUtils.error("will never reach");
    }

}
