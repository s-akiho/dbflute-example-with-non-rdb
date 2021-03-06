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
package org.dbflute.kvs.store;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.dbflute.kvs.core.delegator.KvsDelegator;

/**
 * @author FreeGen
 */
public class KvsStoreManagerImpl implements KvsStoreManager {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Resource
    private KvsDelegator kvsStoreDelegator;

    // ===================================================================================
    //                                                                                Get
    //                                                                               =====
    // -----------------------------------------------------
    //                                                String
    //                                                ------
    @Override
    public String findString(String key) {
        return kvsStoreDelegator.findString(key);
    }

    @Override
    public List<String> findMultiString(List<String> keyList) {
        return kvsStoreDelegator.findMultiString(keyList);
    }

    // -----------------------------------------------------
    //                                                  List
    //                                                  ----
    @Override
    public List<String> findList(String key) {
        return kvsStoreDelegator.findList(key);
    }

    @Override
    public List<List<String>> findMultiList(List<String> keyList) {
        return kvsStoreDelegator.findMultiList(keyList);
    }

    // -----------------------------------------------------
    //                                                  Hash
    //                                                  ----
    @Override
    public List<String> findHash(String key, Set<String> fieldList) {
        return kvsStoreDelegator.findHash(key, fieldList);
    }

    @Override
    public List<List<String>> findMultiHash(List<String> keyList, Set<String> fieldList) {
        return kvsStoreDelegator.findMultiHash(keyList, fieldList);
    }

    // ===================================================================================
    //                                                                            Register
    //                                                                            ========
    // -----------------------------------------------------
    //                                                String
    //                                                ------
    @Override
    public void registerString(String key, String value) {
        kvsStoreDelegator.registerString(key, value);
    }

    @Override
    public void registerString(String key, String value, LocalDateTime expireDateTime) {
        kvsStoreDelegator.registerString(key, value, expireDateTime);
    }

    @Override
    public void registerMultiString(Map<String, String> keyValueMap) {
        kvsStoreDelegator.registerMultiString(keyValueMap);
    }

    @Override
    public void registerMultiString(Map<String, String> keyValueMap, LocalDateTime expireDateTime) {
        kvsStoreDelegator.registerMultiString(keyValueMap, expireDateTime);
    }

    // -----------------------------------------------------
    //                                                  List
    //                                                  ----
    @Override
    public void registerList(String key, List<String> value) {
        kvsStoreDelegator.registerList(key, value);
    }

    @Override
    public void registerList(String key, List<String> value, LocalDateTime expireDateTime) {
        kvsStoreDelegator.registerList(key, value, expireDateTime);
    }

    @Override
    public void registerMultiList(Map<String, List<String>> keyValueMap) {
        kvsStoreDelegator.registerMultiList(keyValueMap);
    }

    @Override
    public void registerMultiList(Map<String, List<String>> keyValueMap, LocalDateTime expireDateTime) {
        kvsStoreDelegator.registerMultiList(keyValueMap, expireDateTime);
    }

    // -----------------------------------------------------
    //                                                  Hash
    //                                                  ----
    @Override
    public void registerHash(String key, Map<String, String> fieldValueMap) {
        kvsStoreDelegator.registerHash(key, fieldValueMap);
    }

    @Override
    public void registerHash(String key, Map<String, String> fieldValueMap, LocalDateTime expireDateTime) {
        kvsStoreDelegator.registerHash(key, fieldValueMap, expireDateTime);
    }

    @Override
    public void registerMultiHash(Map<String, Map<String, String>> keyValueMap) {
        kvsStoreDelegator.registerMultiHash(keyValueMap);
    }

    @Override
    public void registerMultiHash(Map<String, Map<String, String>> keyValueMap, LocalDateTime expireDateTime) {
        kvsStoreDelegator.registerMultiHash(keyValueMap, expireDateTime);
    }

    // ===================================================================================
    //                                                                              Delete
    //                                                                              ======
    @Override
    public void delete(String key) {
        kvsStoreDelegator.delete(key);
    }

    @Override
    public void delete(String... keys) {
        kvsStoreDelegator.delete(keys);
    }

    // ===================================================================================
    //                                                                               Other
    //                                                                               =====
    @Override
    public int getNumActive() {
        return kvsStoreDelegator.getNumActive();
    }
}
