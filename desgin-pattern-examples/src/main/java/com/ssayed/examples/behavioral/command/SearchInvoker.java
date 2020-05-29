package com.ssayed.examples.behavioral.command;

import java.util.Stack;

// command invoker/ sender (will keep the history and call the command)
public class SearchInvoker {
	private Stack<SearchCommand> searchHistory = new Stack<>();

	public SearchResult executeCommand(SearchCommand searchCommand) {
		SearchResult result = searchCommand.execute();
		searchHistory.add(searchCommand);
		return result;
	}

	public SearchResult executeCommandFromHistory(SearchCommand searchCommand) {
		SearchResult result = searchCommand.execute();
		return result;
	}

	public Stack<SearchCommand> getSearchHistory() {
		return searchHistory;
	}
}
