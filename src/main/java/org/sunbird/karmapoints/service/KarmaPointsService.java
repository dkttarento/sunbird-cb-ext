package org.sunbird.karmapoints.service;

import org.sunbird.karmapoints.model.KarmaPointsRequest;

import java.util.Map;

public interface KarmaPointsService {
   public Map<String, Object> fetchKarmaPointsData(String userId, KarmaPointsRequest request) ;

}