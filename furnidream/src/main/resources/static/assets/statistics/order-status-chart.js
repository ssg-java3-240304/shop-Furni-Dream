// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: orderStatusLabels,
    datasets: [{
      data: orderStatusData,
      backgroundColor: ['#F4FF81', '#64FFDA', '#E040FB', '#40C4FF', '#00E676', '#FF1744'],
      // pending	1 '#F4FF81' 라임
      // processing	2 '#64FFDA' 민트
      // shipped	3 '#E040FB' 퍼플
      // delivered	4 '#40C4FF' 블루
      // completed	5 '#00E676' 그린
      // cancelled	6 '#FF1744' 레드
    }],
  },
  options: {
    plugins: {
      datalabels: {
        formatter: function(value, context) {
          return value + ' (' + calculatePercentage(value, total) + ')';
        },
        color: '#000', // 검정색 글씨
        font: {
          family: 'Comic Neue',
          size: 10, // 작은 글씨 크기
          weight: 'bold'
        }
      }
    }
  },
  plugins: [ChartDataLabels]
});