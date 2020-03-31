<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/3/28
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
</head>

<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main_orgStructure" style="width:1200px; height:400px;position: absolute; top: 10%; left: 10%;"></div>
<!-- ECharts单文件引入 -->
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
<script type="text/javascript">
    // 路径配置
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    // 使用
    require(
        [
            'echarts',
            'echarts/chart/tree' // 使用树状图就加载tree模块，按需加载
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('main_orgStructure'));
            var commonStyle = {

            }
            var option = {
                title : {
                    text: '组织结构图'
                },
                tooltip : {
                    show: false,
                    trigger: 'item',
                    formatter: "{b}: {c}"
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : false,
                series : [
                    {
                        name:'树形图',
                        type:'tree',
                        orient: 'vertical',  // vertical horizontal
                        rootLocation: {x: '50%', y: '15%'}, // 根节点位置  {x: 'center',y: 10}
                        nodePadding: 20,
                        layerPadding:40,
                        symbol: 'rectangle',
                        borderColor:'black',
                        itemStyle: {
                            normal: {
                                color: '#fff',//节点背景色
                                label: {
                                    show: true,
                                    position: 'inside',
                                    textStyle: {
                                        color: 'black',
                                        fontSize: 15,
                                        //fontWeight:  'bolder'
                                    }
                                },
                                lineStyle: {
                                    color: '#000',
                                    width: 1,
                                    type: 'broken' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
                                    }
                                },
                                emphasis: {
                                label: {
                                    show: false
                                }
                            }
                        },
                        data: [
                            {
                                name: '董事会',
                                value: 20,
                                symbolSize: [70, 30],
                                symbol: 'rectangle',
                                itemStyle: {
                                    normal: {
                                        borderWidth: 2,
                                        borderColor: 'black'
                                    }
                                },
                                children: [
                                    {
                                        name: '总经理',
                                        value: 6,
                                        symbolSize: [70, 30],
                                        symbol: 'rectangle',
                                        itemStyle: {
                                            normal: {
                                                borderWidth: 2,
                                                borderColor: 'black'
                                            }
                                        },
                                        children: [
                                            {
                                                name: '营销中心',
                                                value: 4,
                                                symbolSize: [70, 30],
                                                symbol: 'rectangle',
                                                itemStyle: {
                                                    normal: {
                                                        label: {
                                                            show: true,
                                                            position: 'inside'
                                                        },
                                                        borderWidth: 2,
                                                        borderColor: 'black'
                                                    }
                                                },
                                                children: [
                                                    {
                                                        name: '市场部',
                                                        value: 4,
                                                        symbolSize: [60, 30],
                                                        symbol: 'rectangle',
                                                        itemStyle: {
                                                            normal: {
                                                                label: {
                                                                    show: true,
                                                                    position: 'inside'
                                                                },
                                                                borderWidth: 2,
                                                                borderColor: 'black'
                                                            }
                                                        },
                                                    },
                                                    {
                                                        name: '销售部',
                                                        value: 4,
                                                        symbolSize: [60, 30],
                                                        symbol: 'rectangle',
                                                        itemStyle: {
                                                            normal: {
                                                                label: {
                                                                    show: true,
                                                                    position: 'inside'
                                                                },
                                                                borderWidth: 2,
                                                                borderColor: 'black'
                                                            }
                                                        },
                                                    },
                                                    {
                                                        name: '客服部',
                                                        value: 4,
                                                        symbolSize: [60, 30],
                                                        symbol: 'rectangle',
                                                        itemStyle: {
                                                            normal: {
                                                                label: {
                                                                    show: true,
                                                                    position: 'inside'
                                                                },
                                                                borderWidth: 2,
                                                                borderColor: 'black'
                                                            }
                                                        },
                                                    }
                                                ]
                                            },
                                            {
                                                name: '项目中心',
                                                value: 4,
                                                symbolSize: [70, 30],
                                                symbol: 'rectangle',
                                                itemStyle: {
                                                    normal: {
                                                        label: {
                                                            show: true,
                                                            position: 'inside'
                                                        },
                                                        borderWidth: 2,
                                                        borderColor: 'black'
                                                    }
                                                },
                                                children: [
                                                    {
                                                        name: '售前支持部',
                                                        value: 4,
                                                        symbolSize: [90, 30],
                                                        symbol: 'rectangle',
                                                        itemStyle: {
                                                            normal: {
                                                                label: {
                                                                    show: true,
                                                                    position: 'inside'
                                                                },
                                                                borderWidth: 2,
                                                                borderColor: 'black'
                                                            }
                                                        },
                                                    },
                                                    {
                                                        name: '项目一部',
                                                        value: 4,
                                                        symbolSize: [70, 30],
                                                        symbol: 'rectangle',
                                                        itemStyle: {
                                                            normal: {
                                                                label: {
                                                                    show: true,
                                                                    position: 'inside'
                                                                },
                                                                borderWidth: 2,
                                                                borderColor: 'black'
                                                            }
                                                        },
                                                    },
                                                    {
                                                        name: '项目二部',
                                                        value: 4,
                                                        symbolSize: [70, 30],
                                                        symbol: 'rectangle',
                                                        itemStyle: {
                                                            normal: {
                                                                label: {
                                                                    show: true,
                                                                    position: 'inside'
                                                                },
                                                                borderWidth: 2,
                                                                borderColor: 'black'
                                                            }
                                                        },
                                                    },
                                                    {
                                                        name: '项目三部',
                                                        value: 4,
                                                        symbolSize: [70, 30],
                                                        symbol: 'rectangle',
                                                        itemStyle: {
                                                            normal: {
                                                                label: {
                                                                    show: true,
                                                                    position: 'inside'
                                                                },
                                                                borderWidth: 2,
                                                                borderColor: 'black'
                                                            }
                                                        },
                                                    }
                                                ]
                                            },
                                            {
                                                name: '技术中心',
                                                value: 4,
                                                symbolSize: [70, 30],
                                                symbol: 'rectangle',
                                                itemStyle: {
                                                    normal: {
                                                        label: {
                                                            show: true,
                                                            position: 'inside'
                                                        },
                                                        borderWidth: 2,
                                                        borderColor: 'black'
                                                    }
                                                },
                                                children: [
                                                    {
                                                        name: '开发部',
                                                        value: 4,
                                                        symbolSize: [70, 30],
                                                        symbol: 'rectangle',
                                                        itemStyle: {
                                                            normal: {
                                                                label: {
                                                                    show: true,
                                                                    position: 'inside'
                                                                },
                                                                borderWidth: 2,
                                                                borderColor: 'black'
                                                            }
                                                        },
                                                    },
                                                    {
                                                        name: '设计部',
                                                        value: 4,
                                                        symbolSize: [70, 30],
                                                        symbol: 'rectangle',
                                                        itemStyle: {
                                                            normal: {
                                                                label: {
                                                                    show: true,
                                                                    position: 'inside'
                                                                },
                                                                borderWidth: 2,
                                                                borderColor: 'black'
                                                            }
                                                        },
                                                    },
                                                    {
                                                        name: '系统部',
                                                        value: 4,
                                                        symbolSize: [70, 30],
                                                        symbol: 'rectangle',
                                                        itemStyle: {
                                                            normal: {
                                                                label: {
                                                                    show: true,
                                                                    position: 'inside'
                                                                },
                                                                borderWidth: 2,
                                                                borderColor: 'black'
                                                            }
                                                        },
                                                    }
                                                ]
                                            },
                                            {
                                                name: '行政部',
                                                value: 4,
                                                symbolSize: [70, 30],
                                                symbol: 'rectangle',
                                                itemStyle: {
                                                    normal: {
                                                        label: {
                                                            show: true,
                                                            position: 'inside'
                                                        },
                                                        borderWidth: 2,
                                                        borderColor: 'black'
                                                    }
                                                }
                                            },
                                            {
                                                name: '财务部',
                                                value: 4,
                                                symbolSize: [70, 30],
                                                symbol: 'rectangle',
                                                itemStyle: {
                                                    normal: {
                                                        label: {
                                                            show: true,
                                                            position: 'inside'
                                                        },
                                                        borderWidth: 2,
                                                        borderColor: 'black'
                                                    }
                                                }
                                            },
                                            {
                                                name: '其他分支',
                                                value: 4,
                                                symbolSize: [70, 30],
                                                symbol: 'rectangle',
                                                itemStyle: {
                                                    normal: {
                                                        label: {
                                                            show: true,
                                                            position: 'inside'
                                                        },
                                                        borderWidth: 2,
                                                        borderColor: 'black'
                                                    }
                                                },
                                                children: [
                                                    {
                                                        name: '汕头分公司',
                                                        value: 4,
                                                        symbolSize: [90, 30],
                                                        symbol: 'rectangle',
                                                        itemStyle: {
                                                            normal: {
                                                                label: {
                                                                    show: true,
                                                                    position: 'inside'
                                                                },
                                                                borderWidth: 2,
                                                                borderColor: 'black'
                                                            }
                                                        },
                                                    }
                                                ]
                                            },
                                        ]
                                    }]
                            }
                        ]
                    }
                ]
            };
            // 为echarts对象加载数据
            myChart.setOption(option);
        });
</script>
</body>