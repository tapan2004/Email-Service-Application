import React, {useRef, useState} from "react";
import toast from "react-hot-toast";
import {sendEmail} from "../services/EmailService.js";
import {Editor} from "@tinymce/tinymce-react";

function EmailSender() {
    const [emailData, setEmailData] = useState({
        to: "",
        subject: "",
        message: "",
    });

    const [loading, setLoading] = useState(false);
    const editorRef = useRef(null);

    function handleField(event, name) {
        setEmailData({...emailData, [name]: event.target.value});
    }

    async function handleSubmit(event) {
        event.preventDefault();

        const editorContent = editorRef.current?.getContent() || "";

        if (!emailData.to || !emailData.subject || !editorContent) {
            toast.error("All fields are required");
            return;
        }

        try {
            setLoading(true);

            await sendEmail({
                to: emailData.to,
                subject: emailData.subject,
                message: editorContent,
            });

            toast.success("Email sent successfully!");

            setEmailData({
                to: "",
                subject: "",
                message: "",
            });

            editorRef.current.setContent("");
        } catch (error) {
            console.error(error);
            toast.error("Failed to send email");
        } finally {
            setLoading(false);
        }
    }

    function handleClear() {
        setEmailData({
            to: "",
            subject: "",
            message: "",
        });

        editorRef.current?.setContent("");
    }

    return (
        <div className="w-full min-h-screen flex justify-center items-center bg-gray-100 px-4">
            <form
                onSubmit={handleSubmit}
                className="w-full max-w-md bg-white p-6 sm:p-8 rounded-xl border shadow space-y-4"
            >
                <h1 className="text-2xl sm:text-3xl font-semibold text-gray-900 text-center">
                    Email Sender
                </h1>

                <p className="text-gray-700 text-sm sm:text-base text-center">
                    Send email to your favorite person with your own words....
                </p>

                {/* TO */}
                <div>
                    <label className="block mb-1 text-sm font-medium text-gray-700">
                        To
                    </label>
                    <input
                        type="email"
                        value={emailData.to}
                        onChange={(e) => handleField(e, "to")}
                        placeholder="Enter recipient email"
                        className="w-full px-3 py-2 border rounded-md text-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
                    />
                </div>

                {/* SUBJECT */}
                <div>
                    <label className="block mb-1 text-sm font-medium text-gray-700">
                        Subject
                    </label>
                    <input
                        type="text"
                        value={emailData.subject}
                        onChange={(e) => handleField(e, "subject")}
                        placeholder="Write subject here..."
                        className="w-full px-3 py-2 border rounded-md text-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
                    />
                </div>

                {/* MESSAGE */}
                <div>
                    <label className="block mb-1 text-sm font-medium text-gray-700">
                        Message
                    </label>

                    <Editor
                        onEditorChange={(event)=>
                    console.log(event,editorRef.current.getContent)}

                        apiKey="5jyhfzhwv9hhiy5nkp6qm2wfwyr7ditby9blj0x3uymz6mm0"
                        onInit={(evt, editor) => (editorRef.current = editor)}
                        init={{
                            plugins: [
                                'anchor', 'autolink', 'charmap', 'codesample', 'emoticons', 'link', 'lists', 'media', 'searchreplace', 'table', 'visualblocks', 'wordcount',
                                'checklist', 'mediaembed', 'casechange', 'formatpainter', 'pageembed', 'a11ychecker', 'tinymcespellchecker', 'permanentpen', 'powerpaste', 'advtable', 'advcode', 'advtemplate', 'ai', 'uploadcare', 'mentions', 'tinycomments', 'tableofcontents', 'footnotes', 'mergetags', 'autocorrect', 'typography', 'inlinecss', 'markdown', 'importword', 'exportword', 'exportpdf'
                            ],
                            toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | link media table mergetags | addcomment showcomments | spellcheckdialog a11ycheck typography uploadcare | align lineheight | checklist numlist bullist indent outdent | emoticons charmap | removeformat',
                            tinycomments_mode: 'embedded',
                            tinycomments_author: 'Author name',
                            mergetags_list: [
                                {value: 'First.Name', title: 'First Name'},
                                {value: 'Email', title: 'Email'},
                            ],
                            ai_request: (request, respondWith) => respondWith.string(() => Promise.reject('See docs to implement AI Assistant')),
                            uploadcare_public_key: '15a82a213016be766185',
                        }}
                    />
                </div>

                {/* LOADER */}
                {loading && (
                    <div className="flex justify-center text-blue-600 text-sm">
                        Sending Email...
                    </div>
                )}

                {/* BUTTONS */}
                <div className="flex gap-3 pt-2">
                    <button
                        type="submit"
                        disabled={loading}
                        className={`flex-1 py-2 rounded-md text-white transition ${
                            loading
                                ? "bg-blue-400 cursor-not-allowed"
                                : "bg-blue-600 hover:bg-blue-700"
                        }`}
                    >
                        {loading ? "Sending..." : "Send Email"}
                    </button>

                    <button
                        type="button"
                        onClick={handleClear}
                        disabled={loading}
                        className="flex-1 border border-gray-300 text-gray-700 py-2 rounded-md hover:bg-gray-100 transition"
                    >
                        Clear
                    </button>
                </div>
            </form>
        </div>
    );
}

export default EmailSender;
