import {customAxios} from "../helper/EmailHelper.js";

export async function sendEmail(emailData) {
    return (await customAxios.post("send-user", emailData)).data;
}