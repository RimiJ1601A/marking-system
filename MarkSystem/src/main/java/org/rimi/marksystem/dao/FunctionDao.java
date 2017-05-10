package org.rimi.marksystem.dao;

import java.util.List;

import org.rimi.marksystem.eneity.Function;
import org.springframework.stereotype.Component;

@Component
public interface FunctionDao {

	public List<Function> selectFunction();
}
