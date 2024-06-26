// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Area Chart Example
var ctx = document.getElementById("myAreaChart");
var monthNames = ["January", "February", "March", "April", "May", "June",
  "July", "August", "September", "October", "November", "December"];

var myLineChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: labels.map(function(month) {
      return monthNames[month - 1]; // labels 배열의 각 요소를 월 이름으로 변환
    }),
    datasets: [{
      label: "Total Sales",
      lineTension: 0.3,
      backgroundColor: "rgba(2,117,216,0.2)",
      borderColor: "rgba(2,117,216,1)",
      pointRadius: 5,
      pointBackgroundColor: "rgba(2,117,216,1)",
      pointBorderColor: "rgba(255,255,255,0.8)",
      pointHoverRadius: 5,
      pointHoverBackgroundColor: "rgba(2,117,216,1)",
      pointHitRadius: 50,
      pointBorderWidth: 2,
      data: dataPoints, // Thymeleaf를 통해 전달된 데이터
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 12
        },
        // scaleLabel: {
        //   display: true,
        //   labelString: '월' // x축 레이블 텍스트 설정
        // }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: Math.max(...dataPoints) , // y축 최대값을 데이터 범위에 맞게 설정 (최대값의 110%)
          // maxTicksLimit:6,
          stepSize:(Math.max(...dataPoints)/5)
          // autoSkip: true, // 자동으로 눈금 간격 조정
          ,
          callback: function(value, index, values) {
            return value.toLocaleString()+ '원'; // y축 눈금값에 원 표시
          }
        },
        gridLines: {
          color: "rgba(0, 0, 0, .125)",
        },
      }],
    },
    legend: {
      display: false
    }
  }
});