// pages/number/guessResult.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    NumberList:"",
    blueList:"",
    rewardList:"",
  },
  //获取最新一期结果
  getNumbers(){
    wx.request({
      url: 'http://192.168.1.32:8080/wx/Number/getPrizeResult',
      method:'GET',
      success:(res)=>{
        this.setData({
           NumberList:res.data.redNum,
           blueList:res.data.blueNum
        })
      }
    })
  },
  getMyPrize(){
    wx.request({
      url: 'http://192.168.1.32:8080/wx/MyGuess/queryMyGuessResult',
      method:'GET',
      success:(res)=>{
        this.setData({
           rewardList:res.data.rewardList,
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getNumbers();
    this.getMyPrize();
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})