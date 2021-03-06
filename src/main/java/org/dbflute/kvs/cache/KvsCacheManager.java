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
package org.dbflute.kvs.cache;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author FreeGen
 */
public interface KvsCacheManager {

    // ===================================================================================
    //                                                                                Get
    //                                                                               =====
    // -----------------------------------------------------
    //                                                String
    //                                                ------
    /**
     * Retrieve a String value corresponding to specified key.
     * @param key Key (NotNull)
     * @return A String value corresponding to key (NullAllowed)
     */
    String findString(String key);

    /**
     * Retrieve all String values corresponding to each key of assigned key-list.
     * @param keyList A list of key (NotNull)
     * @return String values each of which is corresponding to a key in keyList as a List (NotNull)
     */
    List<String> findMultiString(List<String> keyList);

    // -----------------------------------------------------
    //                                                  List
    //                                                  ----
    /**
     * Retrieve a list of String value corresponding to the specified key.
     * <p>
     * このメソッドは、同一キーの処理においてスレッドセーフではありません。<br>
     * これは同一キーでの並列処理が業務上発生しない & 影響は軽微ですので、実装の簡易さのため整合性の担保は行わない方針だからです。
     * (不整合の例:このメソッドはKVSからデータを取得しますが、キャッシュヒットしなかった場合RDBの値でキャッシュをリフレッシュしする実装である場合、
     * 同じタイミングで別スレッドから読み込みが行われた場合不整合なデータが返却されます)
     * </p>
     * @param key Key (NotNull)
     * @return A list of String-values corresponding to specified key (NullAllowd)
     */
    List<String> findList(String key);

    /**
     * Retrieve all lists of String values corresponding to each key of assigned keys.
     * @param keyList A list of key (NotNull)
     * @return Lists of String values corresponding to each key of keys in keyList (NotNull)
     */
    List<List<String>> findMultiList(List<String> keyList);

    // -----------------------------------------------------
    //                                                  Hash
    //                                                  ----
    /**
     * Retrieve a hashmap corresponding to the assigned key and return it as List<String>.
     * @param key Key (NotNull)
     * @param fieldList A set of field(s)  (NotNull)
     * @return A hashmap represented by List of String associated with the assigned key (NullAllowed)
     */
    List<String> findHash(String key, Set<String> fieldList);

    /**
     * Retrieve all hashmaps corresponding to the assigned keys and return them as List<String>.
     * @param keyList A list of keys (NotNull)
     * @param fieldList A set of field(s) (NotNull)
     * @return Hashmaps represented by List of String corresponding to each key of keys in keyList (NotNull)
     */
    List<List<String>> findMultiHash(List<String> keyList, Set<String> fieldList);

    // ===================================================================================
    //                                                                            Register
    //                                                                            ========
    // -----------------------------------------------------
    //                                                String
    //                                                ------
    /**
     * Register a String value into KVS.
     * @param key Key for the value to register (NotNull)
     * @param value String value to register (NotNull)
     */
    void registerString(String key, String value);

    /**
     * Register a String value into KVS with ttl
     * @param key Key for the value to register (NotNull)
     * @param value String value to register (NotNull)
     * @param expireDateTime Time To Live (NullAllowed: use server-config if null is set)
     */
    void registerString(String key, String value, LocalDateTime expireDateTime);

    /**
     * Register all key-value pairs contained in the assigned Map.
     * @param keyValueMap Map of key-value pairs (NotNull)
     */
    void registerMultiString(Map<String, String> keyValueMap);

    /**
     * Register all key-value pairs contained in the assigned Map with ttl.
     * @param keyValueMap Map of key-value pairs (NotNull)
     * @param expireDateTime Time To Live (NullAllowed: use server-config if null is set)
     */
    void registerMultiString(Map<String, String> keyValueMap, LocalDateTime expireDateTime);

    // -----------------------------------------------------
    //                                                  List
    //                                                  ----
    /**
     * Register a list of String values into KVS.
     * @param key Key for the list of String values to register (NotNull)
     * @param value A list of String values to register as a value (NotNull)
     */
    void registerList(String key, List<String> value);

    /**
     * Register a list of String values into KVS with ttl.
     * @param key Key for the list of String values to register (NotNull)
     * @param value A list of String values to register as a value (NotNull)
     * @param expireDateTime Time To Live (NullAllowed: use server-config if null is set)
     */
    void registerList(String key, List<String> value, LocalDateTime expireDateTime);

    /**
     * Register all key-value pairs contained in the assigned Map.
     * @param keyValueMap A Map containing pairs of the key and associated List (NotNull)
     */
    void registerMultiList(Map<String, List<String>> keyValueMap);

    /**
     * Register all key-value pairs contained in the assigned Map with ttl.
     * @param keyValueMap A Map containing pairs of the key and associated List (NotNull)
     * @param expireDateTime Time To Live (NullAllowed: use server-config if null is set)
     */
    void registerMultiList(Map<String, List<String>> keyValueMap, LocalDateTime expireDateTime);

    // -----------------------------------------------------
    //                                                  Hash
    //                                                  ----
    /**
     * Register a hashmap into KVS.
     * @param key A key for the hashmap to register (NotNull)
     * @param fieldValueMap A Map to register (NotNull)
     */
    void registerHash(String key, Map<String, String> fieldValueMap);

    /**
     * Register a hashmap into KVS with ttl.
     * @param key A key for the hashmap to register (NotNull)
     * @param fieldValueMap A Map to register (NotNull)
     * @param expireDateTime Time To Live (NullAllowed: use server-config if null is set)
     */
    void registerHash(String key, Map<String, String> fieldValueMap, LocalDateTime expireDateTime);

    /**
     * Register all key-value pairs contained in the assigned Map.
     * @param keyValueMap A Map containing pairs of the key and associated Map (NotNull)
     */
    void registerMultiHash(Map<String, Map<String, String>> keyValueMap);

    /**
     * Register all key-value pairs contained in the assigned Map with ttl.
     * @param keyValueMap A Map containing pairs of the key and associated Map (NotNull)
     * @param expireDateTime Time To Live (NullAllowed: use server-config if null is set)
     */
    void registerMultiHash(Map<String, Map<String, String>> keyValueMap, LocalDateTime expireDateTime);

    // ===================================================================================
    //                                                                              Delete
    //                                                                              ======
    /**
     * Delete a value corresponding to assigned key.
     * @param key A key associated with the value to be deleted (NotNull)
     */
    void delete(String key);

    /**
     * Delete value(s) corresponding to assigned key(s).
     * @param keys Key(s) associated with the value(s) to be deleted (NotNull)
     */
    void delete(String... keys);

    // ===================================================================================
    //                                                                               Other
    //                                                                               =====
    /**
     * Return the ttl.
     * @param key Key (NotNull)
     * @return The ttl
     */
    Long ttl(String key);

    /**
     * Return the number of active connections in connection pool.
     * @return The number of active connections
     */
    int getNumActive();
}
