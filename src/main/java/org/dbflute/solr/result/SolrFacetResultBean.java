/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.dbflute.solr.result;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.response.FacetField;

/**
 * @author FreeGen
 */
public class SolrFacetResultBean implements SolrResultBean {

    /** クエリー実行時間 */
    private long queryTime;

    /** 実際に発行されたクエリー文字列 */
    private String query;

    /** ファセット結果 */
    private Map<String, Integer> facetResult;

    /** ファセット結果 */
    private List<FacetField> facetFieldList;

    /**
     * クエリー実行時間を取得します。
     * @return クエリー実行時間
     */
    @Override
    public long getQueryTime() {
        return queryTime;
    }

    /**
     * クエリー実行時間を設定します。
     * @param qtime クエリー実行時間
     */
    @Override
    public void setQueryTime(long qtime) {
        this.queryTime = qtime;
    }

    /**
     * 実際に発行されたクエリー文字列を取得します。
     * @return 実際に発行されたクエリー文字列
     */
    @Override
    public String getQueryString() {
        return query;
    }

    /**
     * 実際に発行されたクエリー文字列を設定します。
     * @param query 実際に発行されたクエリー文字列
     */
    @Override
    public void setQueryString(String query) {
        this.query = query;
    }

    /**
     * ファセット結果を取得します。
     * @return ファセット結果
     */
    public Map<String, Integer> getFacetResult() {
        return facetResult;
    }

    /**
     * ファセット結果を設定します。
     * @param facetResult ファセット結果
     */
    public void setFacetResult(Map<String, Integer> facetResult) {
        this.facetResult = facetResult;
    }

    /**
     * ファセット結果を取得します。
     * @return ファセット結果
     */
    public List<FacetField> getFacetFieldList() {
        return facetFieldList;
    }

    /**
     * ファセット結果を設定します。
     * @param facetFieldList ファセット結果
     */
    public void setFacetFieldList(List<FacetField> facetFieldList) {
        this.facetFieldList = facetFieldList;
    }
}
