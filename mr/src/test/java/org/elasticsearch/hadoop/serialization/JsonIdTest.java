/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.hadoop.serialization;

import java.io.InputStream;
import java.util.List;

import org.elasticsearch.hadoop.serialization.json.JacksonJsonParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JsonIdTest {

    private Parser parser;

    @Before
    public void before() {
		InputStream in = getClass().getResourceAsStream("tweet.json");
        parser = new JacksonJsonParser(in);
    }

    @After
    public void after() {
        parser.close();
    }

    @Test
	public void testId() throws Exception {
		List<Object> values = ParsingUtils.values(parser, "id");
		assertEquals(1, values.size());
    }
}