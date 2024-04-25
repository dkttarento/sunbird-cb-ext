package org.sunbird.trending.controller;

import java.util.Map;

public interface TrendingService {
    public Map<String, Object> trendingSearch(Map<String, Object> requestBody, String token) throws Exception;

    public Map<String, Object> trendingContentSearch(Map<String, Object> requestBody, String token) throws Exception;
}
