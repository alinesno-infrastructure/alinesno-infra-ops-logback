package com.alinesno.infra.ops.logback.api.session;

import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.ops.logback.entity.ProjectAccountEntity;
import com.alinesno.infra.ops.logback.entity.ProjectEntity;
import com.alinesno.infra.ops.logback.service.IProjectAccountService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 获取当前应用
 *
 * @author luoxiaodong
 * @since 1.0.0
 */
@Slf4j
@Component
public class CurrentProjectSession {

	@Autowired
	private IProjectAccountService managerApplicationAccountService ;

	public ProjectEntity get() {
		long userId = CurrentAccountJwt.getUserId();
		return managerApplicationAccountService.getApplicationByAccountId(userId) ;
	}

	public void set(long applicationId) {

		long userId = CurrentAccountJwt.getUserId();

		// 查询当前用户配置记录
		long count = managerApplicationAccountService.count(new LambdaQueryWrapper<ProjectAccountEntity>()
				.eq(ProjectAccountEntity::getAccountId , userId)) ;

		ProjectAccountEntity e = new ProjectAccountEntity() ;

		e.setAccountId(userId);
		e.setApplicationId(applicationId);
		e.setAppOrder(count+1);

		managerApplicationAccountService.save(e);
	}

}
