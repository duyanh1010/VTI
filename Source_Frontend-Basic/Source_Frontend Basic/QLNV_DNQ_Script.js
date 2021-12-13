// Trong bài tập này sẽ xử dụng Jquery và JavaScript, JavaScript để thực hiện chức năng quản lý nhân viên, tương ứng với bảng Account trong DB TestingSystem, Các chức năng: Thêm, Sửa, Xóa. Dữ liệu này sẽ tương tác với server Backend API.
// Khai báo 1 array để lưu thông tin tất cả các Account trên hệ thống.
var listAccount = [];

var listDepartment = [];

var listPosition = [];
// var username = document.getElementById("username").value;
// var password = document.getElementById("password").value;
function register() {
    window.location.replace("RegisterPage.html");
}

function getListDepartment() {
    // call API from server
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'GET',
        contentType: "application/json",
        dataType: 'json',
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function(data, textStatus, xhr) {
            data.forEach(function(item) {
                var department = {
                    'id': item.id,
                    'name': item.name,
                }
                listDepartment.push(department)
            });
            for (let index = 0; index < listDepartment.length; index++) {
                $('#Department_ID').append(`
            <option>${listDepartment[index].name}</option>
            `)
            }
        },
        error(jqXHR, textStatus, errorThrown) {
            // alert("Loi");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function getListPosition() {
    $.ajax({
        url: 'http://localhost:8080/api/v1/positions',
        type: 'GET',
        contentType: "application/json",
        dataType: 'json',
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function(data, textStatus, xhr) {
            data.forEach(function(item) {
                var position = {
                    'id': item.id,
                    'name': item.name,
                }
                listPosition.push(position)
            });
            for (let index = 0; index < listPosition.length; index++) {
                $('#Position_ID').append(`
            <option>${listPosition[index].name}</option>
            `)
            }
        },
        error(jqXHR, textStatus, errorThrown) {
            // alert("Loi");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
        // call API from server
    });
}

$(function() {
    //đổ dữ liệu API vào option department
    document.getElementById("infor_Account").innerHTML = storage.getItem("FULL_NAME");

    //ẩn form resend token
    // showAvatar();


    if (storage.getItem("ROLE") == "Admin" || storage.getItem("ROLE") == "Manager") {
        // alert("Bạn là " + storage.getItem("ROLE"))

        getListDepartment();
        //đổ dữ liệu API vào option position
        getListPosition();
        // Gọi hàm load dữ liệu từ Server API khi load trang
        getListEmployees();

        showAvatar();


        $('#Cretate_Date_ID').attr('disabled', 'disabled')
        $('#ID_ID').attr('disabled', 'disabled')
            // $('#Cretate_Date_ID').val("")
            // $('#Email_ID').val("hh")

        // Hàm thực thi khi load đầy đủ các thành phần html
        $('#reset_btn').click(function() {
            // Xử lý sự kiện cho nút reset, Sử dụng JQuery để lấy các giá trị các trường theo ID, sau đó Set về rỗng
            $('#ID_ID').val("")
            $('#Email_ID').val("")
            $('#Username_ID').val("")
            $('#Fullname_ID').val("")
            $('#Department_ID').val("--Select a Department--")
            $('#Position_ID').val("--Select a Position--")
                // $('#Cretate_Date_ID').val(listAccount[7].CreateDate)
            resetPaging();
            resetSort();
        })

        // Xử lý sự kiện khi nhấn nút Save
        $('#Main_Form_ID').submit(function() {

            // Xử lý sự kiện khi nhấn nút Submit của Form(Save), ở đây phải sử dụng Return False ở cuối sự kiện này để không redirect sang trang mới.
            // Lấy các giá trị người dùng nhập vào
            // var v_ID_ID = $('#ID_ID').val()
            var v_Email_ID = $('#Email_ID').val()
            var v_Username_ID = $('#Username_ID').val()
            var v_Fullname_ID = $('#Fullname_ID').val()
            var v_Department_ID = $('#Department_ID').val()
            var v_Position_ID = $('#Position_ID').val()
                // var v_Cretate_Date_ID = $('#Cretate_Date_ID').val()
                // var v_Cretate_Date_ID = "2021-09-08"

            // validate giá trị nhập vào
            if (!v_Email_ID || v_Email_ID.length < 6 || v_Email_ID.length > 50) {
                // show error message
                alert("Email name must be from 6 to 50 characters!");
                return false;
            }
            if (!v_Username_ID || v_Username_ID.length < 6 || v_Username_ID.length > 50) {
                // show error message
                alert("Username name must be from 6 to 50 characters!");
                return false;
            }
            if (!v_Fullname_ID || v_Fullname_ID.length < 6 || v_Fullname_ID.length > 50) {
                // show error message
                alert("Fullname name must be from 6 to 50 characters!");
                return false;
            }
            if (!v_Department_ID || v_Department_ID == '--Select a Department--') {
                // show error message
                alert("Pls choose Department!");
                return false;
            }
            if (!v_Position_ID || v_Position_ID == '--Select a Position--') {
                // show error message
                alert("Pls choose Possition!");
                return false;
            }

            //Lấy ID của Position, Department
            for (let index = 0; index < listPosition.length; index++) {
                if (listPosition[index].name == v_Position_ID) {
                    var posID = listPosition[index].id
                }
            }
            for (let index = 0; index < listDepartment.length; index++) {
                if (listDepartment[index].name == v_Department_ID) {
                    var depID = listDepartment[index].id
                }
            }

            $.ajax({
                url: "http://localhost:8080/api/v1/accounts/EmailExists/" + v_Email_ID,
                type: 'GET',
                contentType: "application/json",
                dataType: 'json', // datatype return
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") +
                        ":" + storage.getItem("PASSWORD")));
                },
                success: function(data, textStatus, xhr) {
                    if (data) {
                        alert("Email đã tồn tại trên hệ thống")
                        return false;
                    } else {
                        // Check Username đã có trên hệ thống hay chưa?
                        $.ajax({
                            url: "http://localhost:8080/api/v1/accounts/UsernameExists/" + v_Username_ID,
                            type: 'GET',
                            contentType: "application/json",
                            dataType: 'json', // datatype return
                            beforeSend: function(xhr) {
                                xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
                            },
                            success: function(data, textStatus, xhr) {
                                if (data) {
                                    alert("Username đã tồn tại trên hệ thống")
                                    return false;
                                } else {
                                    // Add account tới MOCK API
                                    $.ajax({
                                        url: 'http://localhost:8080/api/v1/accounts/',
                                        type: 'POST',
                                        data: JSON.stringify(account), // body
                                        contentType: "application/json", // type of body (json, xml, text)
                                        // dataType: 'json', // datatype return
                                        beforeSend: function(xhr) {
                                            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
                                        },
                                        success: function(data, textStatus, xhr) {
                                            currentPage = totalPages;
                                            showSuccessAlert();
                                            buildTable();
                                        },
                                        error(jqXHR, textStatus, errorThrown) {
                                            alert("Error when loading data");
                                            console.log(jqXHR);
                                            console.log(textStatus);
                                            console.log(errorThrown);
                                        }
                                    });
                                }
                            },
                            error(jqXHR, textStatus, errorThrown) {
                                console.log(jqXHR);
                                console.log(textStatus);
                                console.log(errorThrown);
                            }
                        });
                    }
                },
                error(jqXHR, textStatus, errorThrown) {
                    console.log(jqXHR);
                    console.log(textStatus);
                    console.log(errorThrown);
                }
            });
            // Tạo 1 đối tượng account để lưu giữ thông tin nhận được
            var account = {
                    'email': v_Email_ID,
                    'username': v_Username_ID,
                    'fullname': v_Fullname_ID,
                    'departmentId': depID,
                    'positionId': posID,
                    // 'CreateDate': v_Cretate_Date_ID
                }
                // Add account tới MOCK API
                // $.ajax({
                //     url: 'http://localhost:8080/api/v1/accounts/',
                //     type: 'POST',
                //     data: JSON.stringify(account),
                //     contentType: "application/json",
                //     beforeSend: function(xhr) {
                //         xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
                //     },
                //     success: function(data, textStatus, xhr) {
                //         // success
                //         refreshTable();
                //         showSuccessAlert();
                //         buildTable();
                //         resetDetail();
                //     },
                //     error(jqXHR, textStatus, errorThrown) {
                //         // alert("Loi");
                //         console.log(jqXHR);
                //         console.log(textStatus);
                //         console.log(errorThrown);
                //     }
                // });



            return false;
            // Sử dụng return false để không redirect tới 1 trang khác.
        })
    }
    // else {
    //     alert("Bạn là " + storage.getItem("ROLE"))
    // }
})


// Viết hàm xóa account
function deleteAccount(Index) {
    var v_del_ID = listAccount[Index].id;
    var v_fullname_ID = listAccount[Index].fullname;

    // Hiển thị 1 Confim Popup, chọn Có = True
    var confirm_del = confirm('Bạn có chắc chắn muốn xóa ' + v_fullname_ID + ' không?')
    if (confirm_del) {
        $.ajax({
            url: 'http://localhost:8080/api/v1/accounts/' + v_del_ID,
            type: 'DELETE',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
            },
            success: function(result) {
                // error
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }

                // success
                showSuccessAlert();
                resetPaging();
                getListEmployees();
            }
        });
    } else {
        return
    }
}

// Viết hàm để Edit các account
function editAccount(Index) {
    $('#ID_ID').val(listAccount[Index].id)
    $('#Email_ID').val(listAccount[Index].email)
    $('#Username_ID').val(listAccount[Index].username)
    $('#Fullname_ID').val(listAccount[Index].fullname)
    $('#Department_ID').val(listAccount[Index].department)
    $('#Position_ID').val(listAccount[Index].position)
    $('#Cretate_Date_ID').val(listAccount[Index].createDate)

    $('#Email_ID').attr('disabled', 'disabled')
    $('#Username_ID').attr('disabled', 'disabled')
    $('#Cretate_Date_ID').attr('disabled', 'disabled')

    //  Xử lý sự kiện khi click vào nút Update 
    $('#update_btn').click(function() {
        var v_ID_ID = $('#ID_ID').val()
        var v_Fullname_ID = $('#Fullname_ID').val()
        var v_Department_ID = $('#Department_ID').val()
        var v_Position_ID = $('#Position_ID').val()

        for (let index = 0; index < listPosition.length; index++) {
            if (listPosition[index].name == v_Position_ID) {
                var posID = listPosition[index].id
            }
        }
        for (let index = 0; index < listDepartment.length; index++) {
            if (listDepartment[index].name == v_Department_ID) {
                var depID = listDepartment[index].id
            }
        }
        // Validate fullname
        if (!v_Fullname_ID || v_Fullname_ID.length < 6 || v_Fullname_ID.length > 50) {
            // show error message
            alert("Fullname name must be from 6 to 50 characters!");
            return false;
        }

        var account = {
            'fullname': v_Fullname_ID,
            'departmentId': depID,
            'positionId': posID,
        }
        $.ajax({
            url: 'http://localhost:8080/api/v1/accounts/' + v_ID_ID,
            type: 'PUT',
            data: JSON.stringify(account),
            contentType: "application/json",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
            },
            success: function(data, textStatus, xhr) {
                console.log(data);
                // success
                getListEmployees();
                showSuccessAlert();

                $('#Email_ID').attr('disabled', false)
                $('#Username_ID').attr('disabled', false)

                $('#ID_ID').val("")
                $('#Email_ID').val("")
                $('#Username_ID').val("")
                $('#Fullname_ID').val("")
                $('#Department_ID').val("--Select a Department--")
                $('#Position_ID').val("--Select a Position--")
                $('#Cretate_Date_ID').val("")

            },
            error(jqXHR, textStatus, errorThrown) {
                alert("Loi");
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });

    })
}

// Phân trang, mặc định trang số 1, SL 3
// var accounts = [];
var totalPages;
var currentPage = 1;
var size = 3;

// sort
var sortField = "id";
var sortType = "desc";
var isAsc = false;

// Viết hàm gọi dữ liệu server API bằng Ajax khi load trang Web
function getListEmployees() {
    // call API from server
    var url = "http://localhost:8080/api/v1/accounts";
    url += "?page=" + currentPage + "&size=" + size;
    url += "&sort=" + sortField + "," + (isAsc ? "asc" : "desc");

    var search = document.getElementById('input-search-account').value;

    if (search) {
        url += "&search=" + search;
    }
    $.ajax({
        url: url,
        type: 'GET',
        contentType: "application/json",
        dataType: 'json',
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function(data) {
            accounts = [];
            // success
            accounts = data.content;
            listAccount = data.content;
            showAccount();

            //phân trang
            pagingTable(data.totalPages);
            renderSortUI();
        },
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 401) {
                message = "Sai username hoặc password";
                showNameErrorMessage();
                return;
            } else {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        }
    });
}

function pagingTable(pageAmount) {
    var pagingStr = "";
    if (currentPage == 1) {
        pagingStr += '<li class="page-item disabled" style = "cursor: pointer;"><a class="page-link" style="border: none;" onclick = "prevPaging()" ><i class="fa fa-caret-left" aria-hidden="true"></i></a></li>';
    }
    if (pageAmount > 1 && currentPage > 1) {
        pagingStr += '<li class="page-item" style = "cursor: pointer;"><a class="page-link" style="border: none;" onclick = "prevPaging()" ><i class="fa fa-caret-left" aria-hidden="true"></i></a></li>';
    }

    for (i = 0; i < pageAmount; i++) {
        pagingStr += '<li class="page-item ' + (currentPage == i + 1 ? "active" : "") + ' " style = "cursor: pointer;"><a class="page-link" style="border-radius: 100px; margin-right:5px" onclick = "changePage(' + (i + 1) + ')">' + (i + 1) + '</a></li>';
    }

    if (pageAmount > 1 && currentPage < pageAmount) {
        pagingStr += ' <li class="page-item" style = "cursor: pointer;"><a class="page-link" style="border: none;" onclick = "nextPaging()"><i class="fa fa-caret-right" aria-hidden="true"></i></a></li>';
    }
    if (currentPage == pageAmount) {
        pagingStr += ' <li class="page-item disabled" style = "cursor: pointer;"><a class="page-link" style="border: none;" onclick = "nextPaging()"><i class="fa fa-caret-right" aria-hidden="true"></i></a></li>';
    }

    $('#pagination').empty();
    $('#pagination').append(pagingStr);
}

function resetDetail() {
    $('#Email_ID').attr('disabled', false)
    $('#Username_ID').attr('disabled', false)

    $('#ID_ID').val("")
    $('#Email_ID').val("")
    $('#Username_ID').val("")
    $('#Fullname_ID').val("")
    $('#Department_ID').val("--Select a Department--")
    $('#Position_ID').val("--Select a Position--")
}

function resetPaging() {
    currentPage = 1;
    size = 3;
}

function resetSort() {
    sortField = "id";
    isAsc = false;
}

function resetSearch() {
    document.getElementById('input-search-account').value = "";
}

function handKeyUpEventForSearching(event) {
    if (event.keyCode = 13) {
        event.preventDefault();
        handleSearch();
    }
}

function handleSearch() {
    resetPaging();
    resetSort();
    buildTable();
}

// click vào prev
function prevPaging() {
    changePage(currentPage - 1);
}
// click vào next
function nextPaging() {
    changePage(currentPage + 1);
}

function changePage(page) {
    if (page == currentPage) {
        return;
    }
    currentPage = page;
    buildTable();
}

// sort
function renderSortUI() {
    var sortTypeClazz = isAsc ? "fa-sort-asc" : "fa-sort-desc";

    switch (sortField) {
        case 'Id':
            changeIconSort("heading-id", sortTypeClazz);
            changeIconSort("heading-email", "fa-sort");
            changeIconSort("heading-username", "fa-sort");
            changeIconSort("heading-fullname", "fa-sort");
            break;
        case 'Email':
            changeIconSort("heading-id", "fa-sort");
            changeIconSort("heading-email", sortTypeClazz);
            changeIconSort("heading-username", "fa-sort");
            changeIconSort("heading-fullname", "fa-sort");
            break;
        case 'Username':
            changeIconSort("heading-id", "fa-sort");
            changeIconSort("heading-email", "fa-sort");
            changeIconSort("heading-username", sortTypeClazz);
            changeIconSort("heading-fullname", "fa-sort");
            break;
        case 'Fullname':
            changeIconSort("heading-id", "fa-sort");
            changeIconSort("heading-email", "fa-sort");
            changeIconSort("heading-username", "fa-sort");
            changeIconSort("heading-fullname", sortTypeClazz);
            break;
        default:
            changeIconSort("heading-id", "fa-sort");
            changeIconSort("heading-email", "fa-sort");
            changeIconSort("heading-username", "fa-sort");
            changeIconSort("heading-fullname", "fa-sort");
            break;
    }
}

function changeIconSort(id, sortTypeClazz) {
    document.getElementById(id).classList.remove("fa-sort", "fa-sort-asc", "fa-sort-desc");
    document.getElementById(id).classList.add(sortTypeClazz);
}

function changeSort(field) {
    if (field == sortField) {
        isAsc = !isAsc;
    } else {
        sortField = field;
        isAsc = true;
    }
    buildTable();
}

function buildTable() {
    $('#Result_TB').empty()
        //built bảng => làm trống bảng
    getListEmployees();
}

function refreshTable() {
    resetSearch();
    resetDetail();
    resetPaging();
    resetSort();
    resetDetail();
    buildTable();
}

// hàm chuyển dữ liệu API nhận được bằng Ajax chuyển về dạng List để sử dụng trong chương trình
function parseData(data) {
    // employees = data;
    data.forEach(function(item) {
        var account = {
            'AccountID': item.id,
            'Email': item.email,
            'Username': item.username,
            'FullName': item.fullname,
            'Department': item.department,
            'Position': item.position,
            'CreateDate': item.createDate,
        }
        listAccount.push(account)
    });
}
// Đoạn bên trên khi load hoàn chỉnh trang web sẽ kết thúc ở đây, đoạn dưới sẽ viết các hàm bổ trợ khác
// Viết hàm showAccount()
function showAccount() {
    // Xóa hết kết quả đang hiển thị ở bảng kết quả
    $('#Result_TB').empty()
        // Lặp trong listAccount để in thông tin từng phần tử
        // Hiển thị thêm 2 nút để sửa và xóa các Account
    for (var index = 0; index < listAccount.length; index++) {
        $('#Result_TB').append(`
                  <tr onclick="editAccount(${index})">
                  <th>${listAccount[index].id}</th>
                  <th>${listAccount[index].email}</th>
                  <th>${listAccount[index].username}</th>
                  <th>${listAccount[index].fullname}</th>
                  <th>${listAccount[index].department}</th>
                  <th>${listAccount[index].position}</th>   
                  <th>${listAccount[index].createDate}</th>
                  <th><button class="btn btn-warning" style="padding: 3px 6px 3px 6px" onclick="editAccount(${index})"><i class="fa fa-edit"></i></button></th>
                  <th><button class="btn btn-danger" style="padding: 3px 8px 3px 8px" onclick="deleteAccount(${index})"><i class="fa fa-trash" aria-hidden="true" style="color: black"></i></button></th>
                  </tr>
                  `)
    }
}
// hiển thị thông báo success
function showSuccessAlert() {
    $("#success-alert").fadeTo(1000, 300).slideUp(300, function() {
        $("#success-alert").slideUp(300);
    });
}

// Nhóm hàm Show Avatar
function showAvatar() {
    // Get ImgName
    var url = "http://localhost:8080/api/v1/files/image/";
    url += storage.getItem("ID"); // Gửi kèm id của User đăng nhập cho Backend
    $.ajax({
        url: url,
        type: 'GET',
        // Kiểu dữ liệu trả về là String nên khi chuyển sang bên Frontend sẽ gọi là text.html
        contentType: "text/html", // Đổi kiểu dữ liệu text cho phù hợp với kiểu trả về là tên ảnh trong Backend
        dataType: 'html', // datatype return
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function(data, textStatus, xhr) {
            // Đoạn lệnh này copy từ phần gọi Ajax theo cách không xác thực commemt bên trên xuống.
            // Show Avatar, thêm thể img vào thẻ div tương ứng trong html
            $('.imgAvatar').append(`
            <img src="img/${data}" alt="No image" style="vertical-align: middle; width: 200px; height: 200px; border-radius: 50%;">`)
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

}

// Nhóm hàm Upload ảnh
$('#btn_changeAvatar').click(function() {
    // Test sự kiện onclick
    // console.log('btn_changeAvatar clicked!')
    // Tạo đối tượng Form Data để lưu thông tin gửi đi 
    var myform = $('#form_avatar');
    var fomrData = new FormData(myform[0]);
    // Set file input vào Form data trước khi gửi đi
    fomrData.append('image', $('#files')[0].files[0]);
    // Set id của User đăng nhập vào Form data trước khi gửi đi
    var id = storage.getItem("ID")
    fomrData.append('id', id);

    // fomrData.append('id', '4');

    $.ajax({
        url: 'http://localhost:8080/api/v1/files/image',
        type: 'POST',
        data: fomrData, // body
        processData: false,
        contentType: false, // Không để kiểu Content do đang gửi dữ liệu Formdata
        // dataType: 'json', // datatype return
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function(data, textStatus, xhr) {
            console.log(data);
            showAvatar() // Sau khi thay đổi avatar thành công gọi lại hàm này để show lại ảnh.
        },
        error(jqXHR, textStatus, errorThrown) {
            alert("Error when loading data");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
})

//Hàm xử lý click vào nút Get Token, viết hàm để gửi lại Token
function getToken() {
    var email_id_token = $("#email_id_token").val();
    // console.log("Email nhận được: ", email_id_token);
    // Thực hiện check xem người dùng đã nhập vào Email hay chưa.
    if (email_id_token) {
        var base_URL =
            "http://localhost:8080/api/v1/accountsRegister/userRegistrationConfirmRequest/";
        base_URL += "?email=" + email_id_token;
        // Thực hiện validate Email, kiểm tra xem email có trên hệ thống hay không
        $.ajax({
            url: "http://localhost:8080/api/v1/accounts/EmailExists/" + email_id_token,
            type: 'GET',
            contentType: "application/json",
            dataType: "json", // datatype return
            beforeSend: function(xhr) {
                xhr.setRequestHeader(
                    "Authorization",
                    "Basic " + btoa("duyanh:123456")
                );
            },
            success: function(data, textStatus, xhr) {
                if (data) {
                    // TH này email đã có trên hệ thống, sẽ thực hiện Resent Email token
                    $.ajax({
                        url: base_URL,
                        type: "GET",

                        contentType: "application/json",
                        dataType: "text", // datatype return
                        beforeSend: function(xhr) {
                            xhr.setRequestHeader(
                                "Authorization",
                                "Basic " + btoa("duyanh:123456")
                            );
                        },
                        success: function(data, textStatus, xhr) {
                            alert(
                                "Chúng tôi đã gửi lại cho bạn email để kích hoạt, hãy Check lại."
                            );
                            $("#form1").hide(); // Thực hiện đóng form gửi email Token
                        },
                        error(jqXHR, textStatus, errorThrown) {
                            console.log(jqXHR);
                            console.log(textStatus);
                            console.log(errorThrown);
                        },
                    });
                } else {
                    // TH này Không có email người dùng nhập trên hệ thống
                    alert("Hãy kiểm tra lại thông tin email!!!");
                    return false;
                }
            },
            error(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            },
        });
    } else {
        alert("Hãy nhập vào email!!");
        return false;
    }
}