function deleteFriend (friendId) {
    let delBtn = $("#delBtn"+friendId)
    delBtn.hide(100)
    $.ajax("/friends", {
        method: "POST",
        data: "delId=" + friendId,
        headers: {
            'Encoding-Type': 'UTF-8',
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        success: function (data) {
            let frCard = $("#card"+friendId)
            frCard.hide(200)
        }
    })
}
function addFriend (friendId) {
    let addBtn = $("#addBtn"+friendId)
    addBtn.hide(100)
    $.ajax("/friends", {
        method: "POST",
        data: "addId=" + friendId,
        headers: {
            'Encoding-Type': 'UTF-8',
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        success: function (data) {
            let addTxt = $("#addTxt"+friendId)
            addTxt.show()
        }
    })
}