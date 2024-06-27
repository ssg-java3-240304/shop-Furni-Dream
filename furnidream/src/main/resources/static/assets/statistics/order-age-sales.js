// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';


var ctx = document.getElementById('myChart').getContext('2d');

var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: labels,
        datasets: [
            {
                label: '20 ~ 25세',
                data: salesData1,
                backgroundColor: 'rgb(255,94,124)',
                borderColor: 'rgb(255,94,124)',
                borderWidth: 1
            },
            {
                label: '25 ~ 30세',
                data: salesData2,
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            },
            {
                label: '30 ~ 35세',
                data: salesData3,
                backgroundColor: 'rgba(255, 206, 86, 0.2)',
                borderColor: 'rgba(255, 206, 86, 1)',
                borderWidth: 1
            },
            {
                label: '35 ~ 40세',
                data: salesData4,
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }
        ]
    },


    options: {
        plugins: {
            datalabels: {
                display: false // 데이터 라벨 숨기기
            }
        },
        responsive: true,
        scales: {
            y: {
                beginAtZero: true
            }
        },

    }
});