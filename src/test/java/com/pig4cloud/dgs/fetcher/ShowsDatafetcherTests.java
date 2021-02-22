package com.pig4cloud.dgs.fetcher;

import java.util.List;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author lengleng
 * @date 2021/2/21
 */
@SpringBootTest(classes = {DgsAutoConfiguration.class, ShowsDatafetcher.class})
class ShowsDatafetcherTests {

	@Autowired
	DgsQueryExecutor dgsQueryExecutor;

	@Test
	void shows() {
		List<String> titles = dgsQueryExecutor.executeAndExtractJsonPath(
				" { shows { title releaseYear }}",
				"data.shows[*].title");
		assertThat(titles).contains("java");
	}
}
