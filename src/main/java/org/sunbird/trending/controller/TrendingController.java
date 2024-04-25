package org.sunbird.trending.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sunbird.common.util.Constants;
import java.util.*;
import static org.sunbird.common.util.Constants.*;
@RestController
public class TrendingController {

    @Autowired
    private TrendingService trendingService;

    @PostMapping("/v2/trending/search")
    public ResponseEntity<Map<String, Object>> trendingSearch(
            @RequestBody Map<String, Object> requestBody,
            @RequestHeader(Constants.X_AUTH_TOKEN) String token,@RequestHeader("x-authenticated-user-orgid")String userOrgId) throws Exception {

        Map<String, Object> compositeSearchRes = trendingService.trendingSearch(requestBody,token);
        return new ResponseEntity<>(compositeSearchRes, HttpStatus.OK);
    }

    @PostMapping("admin/trending/content/search")
    public ResponseEntity<Map<String, Object>> trendingContentSearch(
            @RequestBody Map<String, Object> requestBody,
            @RequestHeader(X_AUTH_TOKEN) String token,@RequestHeader(X_AUTH_USER_ORG_ID)String userOrgId) throws Exception {

        Map<String, Object> compositeSearchRes = trendingService.trendingContentSearch(requestBody,token);
        return new ResponseEntity<>(compositeSearchRes, HttpStatus.OK);
    }
}
