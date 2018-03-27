<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>江苏省中西医结合医院</title>
<jsp:include page="/resources/jspHead/jspHead.jsp">
	<jsp:param name="jquery" value="true" />
	<jsp:param name="bootstrap" value="true" />
	<jsp:param name="dialog" value="true" />
	<jsp:param name="placeholder" value="false" />
	<jsp:param name="validationEngine" value="false" />
	<jsp:param name="echarts" value="true" />
	<jsp:param name="datePicker" value="true" />
</jsp:include>

<style type="text/css">
.title {
	margin-top: -5px;
}

.figure {
	font-size: 1.2em;
	color: #6b98ec;
}

.jrgj {
	float: left;
}

.dqbb {
	float: left;
}

.cishu {
	border: 1px solid #85b8ec;
	border-left: none;
}

.gjcs {
	width: 100px;
	margin-top: 0px;
	text-align: right;
	display: block;
	float: left;
	font-size: 25px;
	line-height: 30px;
	font-weight: 700;
	color: #85b8ec;
}

.showInfo {
	margin-top: 30px;
}

.showInfo span {
	font-size: 26px;
	margin-left: 5px;
}

.showInfo button {
	margin-right: 1.3%;
	width: 15%;
	font-size: 14px;
	height: 75px;
}
</style>
</head>
<body style="background: rgb(240, 237, 237);">
	<div id="trend"></div>
	<jsp:include page="navbar.jsp" flush="true" /><!-- 导航条 -->
	<jsp:include page="menu.jsp" flush="true" /><!-- 左侧菜单 -->
	<div class="container-fluid" style="margin-left: 189px;">
		<!-- 右侧区域 -->
		<div class="col-sm-12 col-md-12 col-lg-12 oper-panel">
			<!-- <h3 class="title">首页</h3> -->
			<div class="col-sm-12 col-md-12 col-lg-12 oper-page"
				style="margin-top: 10px;">
				<div class="col-lg-3 " style="padding-left: 0px;">
					<h5 class="title">
						<span style="font-weight: 900;">|</span>&nbsp;总数量统计
					</h5>
				</div>
				<div class="col-lg-3 col-lg-offset-3">
					<h5 class="title">
						<span style="font-weight: 900;">|</span>&nbsp;常用药品TOP3
					</h5>
				</div>
				<div class="showInfo">
					<button class=" btn btn-info">
						中药种类 <span class="badge">${countMedicine}</span>
					</button>
					<button class=" btn btn-success">
						处方数量 <span class="badge">${countPrescription}</span>
					</button>
					<button class=" btn btn-warning">
						证型种类 <span class="badge">${countDisease}</span>
					</button>

					<button class=" btn btn-primary">${empty topMap.keys[0]?'暂无': topMap.keys[0]}<span
							class="badge">${empty topMap.top[0]?0: topMap.top[0]}</span>
					</button>
					<button class=" btn btn-primary">${empty topMap.keys[1]?'暂无': topMap.keys[1]}
						<span class="badge">${empty topMap.top[1]?0: topMap.top[1]}</span>
					</button>
					<button class=" btn btn-primary">${empty topMap.keys[2]?'暂无': topMap.keys[2]}
						<span class="badge">${empty topMap.top[2]?0: topMap.top[2]}</span>
					</button>

				</div>
			</div>
		</div>
		<!-- 概览 -->

		<div class="col-md-6 oper-page2"
			style="background: rgb(240, 237, 237); padding-left: 0px;">
			<div class="oper-page2"
				style="background: #fff; margin-bottom: 0px; padding: 10px;">
				<span class="title"><span style="font-weight: 900;">|</span>&nbsp;常见中医诊断证型统计</span>
				<div class="form-group" style="margin-top: 15px; margin-left: 9px;">
					<span style="font-size: 16px;">就诊日期：</span> <input type="text"
						class="datepicker btn btn-default " id="startTime"
						onchange="checkDate()" placeholder="起始时间" name="startTime"
						value="${startTime }" readonly="readonly"
						style="width: 120px; background: white;"> - <input
						type="text" class="datepicker btn btn-default" id="endTime"
						onchange="checkDate()" placeholder="结束时间" name="endTime"
						value="${endTime }" readonly="readonly"
						style="width: 120px; background: white;">
					<button type="button" class="btn btn-default" onclick="search()">查询</button>
				</div>
				<div id="diseaseInfo" style="width: 95%; height: 472px; left: 30px;"></div>

			</div>
		</div>
		<div class="col-md-6 oper-page2"
			style="background: rgb(240, 237, 237); padding-left: 0px; background-color: #fff;">
			<div class="oper-page2"
				style="background: #fff; margin-bottom: 0px; padding: 10px;">
				<span class="title"><span style="font-weight: 900;">|</span>&nbsp;常用中药统计</span>
				<div class="form-group" style="margin-top: 15px; margin-left: 9px;">
					<span style="font-size: 16px;">就诊日期：</span> <input type="text"
						class="datepicker btn btn-default " id="startTimes"
						onchange="checkDate1()" placeholder="起始时间" name="startTimes"
						value="${startTime }" readonly="readonly"
						style="width: 120px; background: white;"> - <input
						type="text" class="datepicker btn btn-default" id="endTimes"
						onchange="checkDate1()" placeholder="结束时间" name="endTimes"
						value="${endTime }" readonly="readonly"
						style="width: 120px; background: white;">
					<button type="button" class="btn btn-default"
						onclick="searchMedicines()">查询</button>
				</div>
				<div id="medicineInfo"
					style="width: 95%; height: 472px; left: 50px;"></div>

			</div>
		</div>

		<script type="text/javascript">
			$(function() {
				$('.datepicker').datepicker();
				var startTime = $("#startTime").val();
				var endTime = $("#endTime").val();
				var startTimes = $("#startTimes").val();
				var endTimes = $("#endTimes").val();
				prescription(startTime, endTime);
				medicineInfo(startTimes, endTimes);
			});

			function checkDate() {
				var startTime = $("#startTime").val();
				var endTime = $("#endTime").val();
				if (startTime && endTime) {
					if (startTime > endTime) {
						dialogShow("结束时间必须大于开始时间");
						$("#endTime").val("");
					} else {
						return true;
					}
				}
			}

			function checkDate1() {
				var startTime = $("#startTimes").val();
				var endTime = $("#endTimes").val();
				if (startTime && endTime) {
					if (startTime > endTime) {
						dialogShow("结束时间必须大于开始时间");
						$("#endTimes").val("");
					} else {
						return true;
					}
				}
			}

			function search() {
				var startTime = $("#startTime").val();
				var endTime = $("#endTime").val();
				prescription(startTime, endTime);
			}

			function searchMedicines() {
				var startTimes = $("#startTimes").val();
				var endTimes = $("#endTimes").val();
				medicineInfo(startTimes, endTimes);
			}

			function prescription(startTime, endTime) {
				/* document.getElementById('diseaseInfo').innerHTML = '';  */
				prjSourceAkhtj = echarts.init(document
						.getElementById('diseaseInfo'));
				optionPrjSourceAkhtj = {

					tooltip : {
						trigger : 'item',
						formatter : "{a} <br/>{b}: {c} ({d}%)"
					},
					legend : {
						/*orient: 'vertical',*/
						x : 'right',
						left : 'left',
						top : 'top',
						selectedMode : false,
						textStyle : {
							fontFamily : '宋体',
							color : '#686868'
						},
						data : []
					},

					color : [ '#31B0D5', '#449D44', '#EC971F', '#286090',
							'#999999', '#D6403B', '#24dd9C', '#27BB9C',
							'#2477dC', '#F75000', '#80FFFF', '#93FF93',
							'#FFA042', '#95CACA' ],
					series : [ {
						name : '',
						type : 'pie',
						radius : [ '25%', '66%' ],
						avoidLabelOverlap : true,
						center : [ '50%', '55%' ],
						color : [ '#31B0D5', '#449D44', '#EC971F', '#286090',
								'#999999', '#D6403B', '#24dd9C', '#27BB9C',
								'#2477dC', '#F75000', '#80FFFF', '#93FF93',
								'#FFA042', '#95CACA' ],
						itemStyle : {
							normal : {
								label : {
									show : true

								},
								labelLine : {
									show : true,
									length : 5,
									length2 : 5,
									smooth : false
								},
								borderWidth : 2,
								borderColor : '#FFF'
							}
						},
						data : []
					} ]
				};
				var url = "${path}/main/getCountDisease";
				var data = {
					startTime : startTime,
					endTime : endTime
				};
				$
						.ajax({
							type : 'GET',
							url : url,
							dataType : 'json',
							data : data,
							async : false,
							success : function(map) {
								for (var k = 0; k < map.countDiseaseList.length; k++) {
									if (map.countDiseaseList.length == 1
											&& map.countDiseaseList[k].text == "其他") {
										optionPrjSourceAkhtj.series[0].data[k] = {
											value : Number(map.countDiseaseList[k].count),
											name : '其他'
										};
									} else if (map.countDiseaseList[k].count != 0
											&& map.countDiseaseList[k].text != null) {
										var value = Number(map.countDiseaseList[k].count);
										optionPrjSourceAkhtj.series[0].data[k] = {
											value : value,
											name : ''
										};
									}
								}

								for (var i = 0; i < optionPrjSourceAkhtj.series[0].data.length; i++) {
									if (map.countDiseaseList[i].count != 0) {
										optionPrjSourceAkhtj.legend.data
												.push(map.countDiseaseList[i].text);
										optionPrjSourceAkhtj.series[0].data[i].name = (map.countDiseaseList[i].text);

										optionPrjSourceAkhtj.series[0].data[i].value = map.countDiseaseList[i].count;
									}

									if (optionPrjSourceAkhtj.series[0].data[i].value == 0) {
										prjSourceAkhtj
												.setOption({
													legend : {
														selected : {
															'optionPrjSourceAkhtj.legend.data[i]' : false
														}
													}
												});

									}
									prjSourceAkhtj
											.setOption(optionPrjSourceAkhtj);

								}

							}
						});
			}

			function medicineInfo(startTimes, endTimes) {

				//document.getElementById('medicineInfo').innerHTML = '';  
				prjSourceAkhtj2 = echarts.init(document
						.getElementById('medicineInfo'));
				optionPrjSourceAkhtj2 = {
					tooltip : {
						trigger : 'item',
						formatter : "{a} <br/>{b}: {c} ({d}%)"
					},
					legend : {
						/*orient: 'vertical',*/
						x : 'right',
						left : 'left',
						top : 'top',
						selectedMode : false,
						textStyle : {
							fontFamily : '宋体',
							color : '#686868'
						},
						data : []
					},

					color : [ '#31B0D5', '#449D44', '#EC971F', '#286090',
							'#999999', '#D6403B', '#24dd9C', '#27BB9C',
							'#2477dC', '#F75000', '#80FFFF', '#93FF93',
							'#FFA042', '#95CACA' ],
					series : [ {
						name : '',
						type : 'pie',
						radius : [ '25%', '66%' ],
						avoidLabelOverlap : true,
						center : [ '50%', '55%' ],
						color : [ '#31B0D5', '#449D44', '#EC971F', '#286090',
								'#999999', '#D6403B', '#24dd9C', '#27BB9C',
								'#2477dC', '#F75000', '#80FFFF', '#93FF93',
								'#FFA042', '#95CACA' ],
						itemStyle : {
							normal : {
								label : {
									show : true

								},
								labelLine : {
									show : true,
									length : 5,
									length2 : 5,
									smooth : false
								},
								borderWidth : 2,
								borderColor : '#FFF'
							}
						},
						data : []
					} ]
				};
				var url = "${path}/main/getCountMedicines";
				var data = {
					startTime : startTimes,
					endTime : endTimes
				};
				$
						.ajax({
							type : 'GET',
							url : url,
							dataType : 'json',
							data : data,
							async : false,
							success : function(map) {
								for (var k = 0; k < map.countMedicinesList.length; k++) {
									if (map.countMedicinesList.length == 1
											&& map.countMedicinesList[k].medicineName == "其他") {
										optionPrjSourceAkhtj2.series[0].data[k] = {
											value : Number(map.countMedicinesList[k].count),
											name : '其他'
										};
									} else if (map.countMedicinesList[k].count != 0
											&& map.countMedicinesList[k].medicineName != null) {
										var value = Number(map.countMedicinesList[k].count);
										optionPrjSourceAkhtj2.series[0].data[k] = {
											value : value,
											name : ''
										};
									}
								}

								for (var i = 0; i < optionPrjSourceAkhtj2.series[0].data.length; i++) {
									if (map.countMedicinesList[i].count != 0) {
										optionPrjSourceAkhtj2.legend.data
												.push(map.countMedicinesList[i].medicineName);
										optionPrjSourceAkhtj2.series[0].data[i].name = map.countMedicinesList[i].medicineName;

										optionPrjSourceAkhtj2.series[0].data[i].value = map.countMedicinesList[i].count;
									}

									if (optionPrjSourceAkhtj2.series[0].data[i].value == 0) {
										prjSourceAkhtj2
												.setOption({
													legend : {
														selected : {
															'optionPrjSourceAkhtj2.legend.data[i]' : false
														}
													}
												});

									}
									prjSourceAkhtj2
											.setOption(optionPrjSourceAkhtj2);

								}

							}
						});
			}
		</script>
</body>
</html>