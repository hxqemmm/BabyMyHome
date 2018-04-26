<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <!-- 显示时间，天气 -->
	<script src="js/jquery.mins.js"></script>
	<script src="js/jquery.leoweather.min.js"></script>

	<span id="weather"></span>
	<script>
		$('#weather').leoweather({format:'{时段}好！，<span id="colock">现在时间是：<strong>{年}年{月}月{日}日  星期{周}  {时}:{分}:{秒}</strong>，</span> <b>{城市}天气</b> {天气} {夜间气温}℃ ~ {白天气温}℃'});
	</script>
