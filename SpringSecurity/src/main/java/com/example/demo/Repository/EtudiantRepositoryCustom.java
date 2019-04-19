package com.example.demo.Repository;

import java.util.List;
import java.util.Map;

public interface EtudiantRepositoryCustom {

	
	
	public List<Map<Long,Map<String, Object>>> findAllEtudiantJoinCours();
}
