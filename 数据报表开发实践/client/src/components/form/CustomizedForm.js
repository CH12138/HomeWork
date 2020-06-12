import React, { Component } from 'react';
import { Modal, Form, Input, Radio, InputNumber, Cascader, Select, AutoComplete } from 'antd';
import axios from 'axios';
// import address from './request/address';

const FormItem = Form.Item;
const Option = Select.Option;
const AutoCompleteOption = AutoComplete.Option;
const options = [];

class CustomizedForm extends Component{
    state = {
        autoCompleteResult: [],
    };
    constructor(props){
        super(props);
    }
    componentDidMount(){
        axios.get('')
            .then(function (response) {
                response.data.map(function(province){
                    options.push({
                        value: province.name,
                        label: province.name,
                        children: province.city.map(function(city){
                            return {
                                value: city.name,
                                label: city.name,
                                children: city.area.map(function(area){
                                    return {
                                        value: area,
                                        label: area,
                                    }
                                })
                            }
                        }),
                    })
                })
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    handleWebsiteChange = (value) => {
        let autoCompleteResult;
        if (!value) {
            autoCompleteResult = [];
        } else {
            autoCompleteResult = ['.com', '.cn', '.org', '.net'].map(domain => `${value}${domain}`);
        }
        this.setState({ autoCompleteResult });
    };
    render(){
        const { visible, onCancel, onCreate, form, okText, title } = this.props;
        const { getFieldDecorator } = form;
        const { autoCompleteResult } = this.state;
        const FormItemLayout = {
            labelCol: { span: 5 },
            wrapperCol: { span: 16 },
        };
        const websiteOptions = autoCompleteResult.map(website => (
            <AutoCompleteOption key={website}>{website}</AutoCompleteOption>
        ));
        return (
            <Modal
                visible={visible}
                title={title}
                okText={okText}
                onCancel={onCancel}
                onOk={onCreate}
            >
                <Form layout="horizontal">
                    <FormItem label="姓名" {...FormItemLayout} hasFeedback>
                        {getFieldDecorator('surname', {
                            rules: [{ required: true, message: '请输入姓名！' }],
                        })(
                            <Input />
                        )}
                    </FormItem>
                    <FormItem label="性别" {...FormItemLayout} hasFeedback>
                        {getFieldDecorator('sex', {
                            rules: [{ required: true, message: '请选择性别！' }],
                        })(
                            <Radio.Group style={{marginRight: 20}}>
                                <Radio value='男'>男</Radio>
                                <Radio value='女'>女</Radio>
                            </Radio.Group>
                        )}
                    </FormItem>
                    <FormItem label="教育状况" {...FormItemLayout} hasFeedback>
                        {getFieldDecorator('educa_des', {
                            rules: [{ required: true, message: '请输入教育状况！' }],
                        })(
                            <Input />
                        )}
                    </FormItem>
                    <FormItem label="婚姻状况" {...FormItemLayout} hasFeedback>
                        {getFieldDecorator('mar_des', {
                            rules: [{ required: true, message: '请输入婚姻状况！' }],
                        })(
                            <Input />
                        )}
                    </FormItem>
                    <FormItem label="生日" {...FormItemLayout} hasFeedback>
                        {getFieldDecorator('phone', {
                            rules: [{required: true, message: '请输入生日！'}],
                        })(
                            <Input  />
                        )}
                    </FormItem>
                    <FormItem label="地址" {...FormItemLayout} hasFeedback>
                        {getFieldDecorator('email', {
                            rules: [{required: true, message: '请输入地址！',
                            }],
                        })(
                            <Input />
                        )}
                    </FormItem>
                </Form>
            </Modal>
        );
    }
}

const CollectionCreateForm = Form.create()(CustomizedForm);
export default CollectionCreateForm;