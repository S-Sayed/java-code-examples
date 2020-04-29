package com.ssayed.examples.structural.adapter;

import com.ssayed.examples.structural.adapter.ThirdPartyRichChartDrawing.RichChart;

public class SimpleAdapterExample {

	public static void main(String[] args) {
		DrawService service = new DrawService();
		String xml = "<xml>Input in XML format<xml>";
		System.out.println(service.draw(ChartType.NORMAL, xml));

		System.out.println("|---------------------------|");
		System.out.println("|------ Object Adapter -----|");
		System.out.println("|---------------------------|");
		System.out.println(service.draw(ChartType.RICH, xml));

		System.out.println("|---------------------------|");
		System.out.println("|------- Class Adapter -----|");
		System.out.println("|---------------------------|");
		System.out.println(new ThirdPartyRichChartDrawingClassAdapter().draw(xml));
	}
}

class DrawService {
	public Chart draw(ChartType drawType, String xml) {
		if (drawType == ChartType.NORMAL) {
			// using our API
			return new NormalChartDrawing().draw(xml);
		} else if (drawType == ChartType.RICH) {
			// using rich third party API
			return new ThirdPartyRichChartDrawingObjectAdapter().draw(xml);
		}

		return null;
	}
}

enum ChartType {
	NORMAL, RICH;
}

// target that client expect
class Chart {
	private ChartType type;
	private String data;

	public ChartType getType() {
		return type;
	}

	public void setType(ChartType type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Chart Type: [" + type + "], data: [" + data + "]";
	}
}

// target that client deal with
interface ChartDrawingI {
	Chart draw(String xml);
}

class NormalChartDrawing implements ChartDrawingI {
	public Chart draw(String xml) {
		Chart chart = new Chart();
		chart.setType(ChartType.NORMAL);
		chart.setData("Hello Normal Chart");
		return chart;
	}
}

// object adapter
class ThirdPartyRichChartDrawingObjectAdapter implements ChartDrawingI {
	// adaptee
	ThirdPartyRichChartDrawing richChartDrawing = new ThirdPartyRichChartDrawing();

	@Override
	public Chart draw(String xml) {
		String json = convertXMLToJSON(xml);
		RichChart richChart = richChartDrawing.drawRichChart(json);
		Chart chart = new Chart();
		chart.setType(ChartType.RICH);
		chart.setData("Object Adapter: " + richChart.getData());
		return chart;
	}

	private String convertXMLToJSON(String xml) {
		return "Data in JSON format";
	}
}

// class adapter
// extends adaptee ThirdPartyRichChartDrawing using inheritance instead of
// composition
class ThirdPartyRichChartDrawingClassAdapter extends ThirdPartyRichChartDrawing implements ChartDrawingI {

	@Override
	public Chart draw(String xml) {
		String json = convertXMLToJSON(xml);
		RichChart richChart = super.drawRichChart(json);
		Chart chart = new Chart();
		chart.setType(ChartType.RICH);
		chart.setData("Class Adapter: " + richChart.getData());
		return chart;
	}

	private String convertXMLToJSON(String xml) {
		return "Data in JSON format";
	}
}

// the below code is not compatible with our existing code
// adaptee
class ThirdPartyRichChartDrawing {
	public RichChart drawRichChart(String json) {
		RichChart richChart = new RichChart();
		richChart.setData("Hello Rich Chart");
		return richChart;
	}

	class RichChart {
		private String data;

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}
	}
}
