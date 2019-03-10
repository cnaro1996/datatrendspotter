import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import ReactChartkick, { LineChart, PieChart } from 'react-chartkick'
import Chart from 'chart.js'

ReactChartkick.addAdapter(Chart)

class App extends Component {
  state = {
    isLoading: true,
    datasets: []
  };

  async componentDidMount() {
    const response = await fetch('/api/datasets');
    const body =  await response.json();
    this.setState({ datasets: body, isLoading: false});
  }

  render() {
    const {datasets, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <header className="App-header">
          <div>
            <h1>Trend Spotter</h1>
          </div>
          <img src={logo} className="App-logo" alt="logo" />
          <div>
            <LineChart id="Age vs. Maximum Heartrate" 
            data={{63: 150, 37: 187, 41: 172, 56: 178, 57: 163,
             57: 148, 56: 153}} colors={["#fff", "#fff",]}
             xtitle = "Age" ytitle = "Maximum Heartrate" />
          </div>
          <div className = "App-intro">
            <h2>Dataset List</h2>
            {datasets.map(dataset =>
              <div key={dataset.id}>
                {dataset.name}
              </div>
            )}
          </div>
        </header>
      </div>
    );
  }
}

export default App;
