/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package com.manning.javapersistence.ch05.model;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    @NotNull
    @Size(
            min = 2,
            max = 255,
            message = "Name is required, maximum 255 characters."
    )
    private String name;

    @Future
    protected Date auctionEnd;

    public Long getId() { // Optional but useful
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public static void main(String[] args) {
        Map<String, List<Map<String, Integer>>> map = new HashMap<>();
        List<Map<String, Integer>> list = new ArrayList<>();
        Map<String, Integer> innerMap1 = new HashMap<>();
        Map<String, Integer> innerMap2 = new HashMap<>();
        Map<String, Integer> innerMap3 = new HashMap<>();

        innerMap1.put("key1", 1);
        innerMap1.put("key2", 2);
        innerMap1.put("key3", 3);
        innerMap1.put("key4", 4);
        innerMap1.put("key5", 5);
        innerMap1.put("key6", 6);

        innerMap2.put("key1", 1);
        innerMap2.put("key2", 2);
        innerMap2.put("key3", 3);
        innerMap2.put("key4", 4);
        innerMap2.put("key5", 5);
        innerMap2.put("key6", 6);

        innerMap3.put("key1", 1);
        innerMap3.put("key2", 2);
        innerMap3.put("key3", 3);
        innerMap3.put("key4", 4);
        innerMap3.put("key5", 5);
        innerMap3.put("key6", 6);

        list.add(innerMap1);
        list.add(innerMap2);
        list.add(innerMap3);

        map.put("key1", list);

        for (String s : map.keySet()) {
            List<Map<String, Integer>> maps = map.get(s);
            for (Map<String, Integer> stringIntegerMap : maps) {
                for (String string : stringIntegerMap.keySet()) {
                    System.out.println(stringIntegerMap.get(string));
                }
            }
        }
    }
    public void Test() {

    }
}
