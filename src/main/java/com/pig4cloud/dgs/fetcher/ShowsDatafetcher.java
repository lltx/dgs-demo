package com.pig4cloud.dgs.fetcher;

import java.util.List;
import java.util.stream.Collectors;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.pig4cloud.dgs.model.Show;

/**
 *
 * @author lengleng
 * @date 2021/2/20
 */
@DgsComponent
public class ShowsDatafetcher {

	private final List<Show> shows = List.of(
			new Show("java", 1995),
			new Show("php", 1995),
			new Show("python", 1990),
			new Show("golang", 2009),
			new Show("rust", 2015)
	);

	@DgsData(parentType = "Query", field = "shows")
	public List<Show> shows(@InputArgument("title") String title, @InputArgument("releaseYear") Integer releaseYear) {
		if (title == null) {
			return shows;
		}

		return shows.stream().filter(s -> s.getTitle().contains(title)).collect(Collectors.toList());
	}
}
